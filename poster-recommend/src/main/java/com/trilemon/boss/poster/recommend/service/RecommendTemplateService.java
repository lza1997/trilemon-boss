package com.trilemon.boss.poster.recommend.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendFavoriteTemplateDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendRecommendTemplateDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendFavoriteTemplate;
import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.dao.PosterTemplateCategoryDAO;
import com.trilemon.boss.poster.template.dao.PosterTemplateTopicDAO;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.boss.poster.template.model.PosterTemplateCategory;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author kevin
 */
@Service
public class RecommendTemplateService {
    @Autowired
    private PosterRecommendRecommendTemplateDAO posterRecommendRecommendTemplateDAO;
    @Autowired
    private PosterRecommendFavoriteTemplateDAO posterRecommendFavoriteTemplateDAO;
    @Autowired
    private PosterTemplateCategoryDAO posterTemplateCategoryDAO;
    @Autowired
    private PosterTemplateTopicDAO posterTemplateTopicDAO;
    @Autowired
    private PosterRecommendActivityDAO posterRecommendActivityDAO;
    @Autowired
    private PosterTemplateClient posterTemplateClient;
    @Autowired
    private AppService appService;
    private List<PosterTemplateCategory> posterTemplateCategories;
    private List<PosterTemplateTopic> posterTemplateTopics;

    /**
     * 获取推荐模板
     *
     * @param userId
     * @return
     */
    public List<PosterRecommendRecommendTemplate> getRecommendPosterTemplate(Long userId, Byte recommendType) {
        return posterRecommendRecommendTemplateDAO.selectByRecommendType(recommendType,
                appService.getLocalSystemTime().toDate());
    }

    /**
     * 模板翻页
     *
     * @param topicIds
     * @param categoryIds
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginatePosterTemplates(Long userId, List<Integer> topicIds, List<Integer> categoryIds,
                                                        int pageNum, int pageSize) {
        PosterTemplateQueryRequest request = new PosterTemplateQueryRequest();
        request.setTopicIds(topicIds);
        request.setCategoryIds(categoryIds);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        PosterTemplateQueryResponse response = posterTemplateClient.queryTemplates(request);

        Page<PosterTemplate> page = Page.empty();
        if (null != response && null != response.getPosterTemplatePage()) {
            page = response.getPosterTemplatePage();
            List<PosterTemplate> posterTemplates = page.getItems();
            List<Long> templateIds = Lists.transform(posterTemplates, new Function<PosterTemplate, Long>() {
                @Nullable
                @Override
                public Long apply(@Nullable PosterTemplate input) {
                    return input.getId();
                }
            });
            List<PosterRecommendFavoriteTemplate> favoriteTemplates = posterRecommendFavoriteTemplateDAO.selectByUserIdAndTemplateIds(userId, templateIds);
            if (CollectionUtils.isNotEmpty(favoriteTemplates)) {
                for (PosterRecommendFavoriteTemplate favoriteTemplate : favoriteTemplates) {
                    for (PosterTemplate template : posterTemplates) {
                        if (favoriteTemplate.getTemplateId().equals(template.getId())) {
                            template.setFavorite(true);
                        }
                    }
                }
            }
        }
        return page;
    }

    /**
     * 收藏模板翻页
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginateFavoritePosterTemplates(Long userId, int pageNum, int pageSize) {
        List<PosterRecommendFavoriteTemplate> favorites = posterRecommendFavoriteTemplateDAO.paginateByUserId(userId,
                (pageNum - 1) * pageSize, pageSize);
        int count = posterRecommendFavoriteTemplateDAO.countByUserId(userId);
        if (CollectionUtils.isEmpty(favorites)) {
            return Page.create(count, pageNum, pageSize, Lists.<PosterTemplate>newArrayList());
        } else {
            List<PosterTemplate> templates = getTemplates(Lists.transform(favorites,
                    new Function<PosterRecommendFavoriteTemplate, Long>() {
                        @Nullable
                        @Override
                        public Long apply(@Nullable PosterRecommendFavoriteTemplate input) {
                            return input.getTemplateId();
                        }
                    }));
            return Page.create(count, pageNum, pageSize, templates);
        }
    }

    private List<PosterTemplate> getTemplates(List<Long> templateIds) {
        return posterTemplateClient.getPosterTemplates(templateIds);
    }

    /**
     * 最新模板翻页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginateLatestPosterTemplates(int pageNum, int pageSize) {
        PosterTemplateQueryRequest request = new PosterTemplateQueryRequest();
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        request.setOrderBy("upd_time desc");
        PosterTemplateQueryResponse response = posterTemplateClient.queryTemplates(request);
        if (null == response || null == response.getPosterTemplatePage()) {
            return Page.empty();
        } else {
            return response.getPosterTemplatePage();
        }
    }

    /**
     * 获取用户曾经使用过的模板
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginateUsedPosterTemplates(Long userId, int pageNum, int pageSize) {
        List<PosterTemplate> templates = Lists.newArrayList();
        List<PosterRecommendActivity> activities = posterRecommendActivityDAO.paginateActivityByUserId(userId,
                null, null, "add_time desc", (pageNum - 1) * pageSize, pageSize);
        int count = posterRecommendActivityDAO.countActivityByUserId(userId, null, null);
        if (CollectionUtils.isEmpty(activities)) {
            return Page.empty();
        } else {
            for (PosterRecommendActivity activity : activities) {
                PosterTemplate template = posterTemplateClient.getPosterTemplate(activity.getTemplateId());
                templates.add(template);
            }
            return Page.create(count, pageNum, pageSize, templates);
        }
    }

    /**
     * 根据 ID 获取模板
     *
     * @param id
     * @return
     */
    public PosterTemplate getTemplate(Long id) {
        return posterTemplateClient.getPosterTemplate(id);
    }

    /**
     * 获取目录
     *
     * @return
     */
    public List<PosterTemplateCategory> getTemplateCategories() {
        if (CollectionUtils.isEmpty(posterTemplateCategories)) {
            refreshTemplateCategories();
        }
        return posterTemplateCategories;
    }

    /**
     * 获取主题
     *
     * @return
     */
    public List<PosterTemplateTopic> getTemplateTopics() {
        if (CollectionUtils.isEmpty(posterTemplateTopics)) {
            refreshTemplateTopics();
        }
        return posterTemplateTopics;
    }

    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void refreshTemplateTopics() {
        posterTemplateTopics = posterTemplateTopicDAO.selectAll();
    }

    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void refreshTemplateCategories() {
        posterTemplateCategories = posterTemplateCategoryDAO.selectAll();
    }

    /**
     * 收藏
     *
     * @param userId
     * @param templateId
     */
    public void favoriteTemplate(Long userId, Long templateId) {
        PosterRecommendFavoriteTemplate posterRecommendFavoriteTemplate = new PosterRecommendFavoriteTemplate();
        posterRecommendFavoriteTemplate.setUserId(userId);
        posterRecommendFavoriteTemplate.setTemplateId(templateId);
        posterRecommendFavoriteTemplate.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendFavoriteTemplateDAO.insertSelective(posterRecommendFavoriteTemplate);
        posterTemplateClient.favoriteTemplate(templateId, 1);
    }

    /**
     * 取消收藏
     *
     * @param userId
     * @param templateId
     */
    public void unFavoriteTemplate(Long userId, Long templateId) {
        posterRecommendFavoriteTemplateDAO.deleteByUserIdAndTemplateId(userId, templateId);
        posterTemplateClient.favoriteTemplate(templateId, -1);
    }
}
