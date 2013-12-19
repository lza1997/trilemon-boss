package com.trilemon.boss.poster.recommend.service;

import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendRecommendTemplateDAO;
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

import java.util.List;

/**
 * @author kevin
 */
@Service
public class RecommendTemplateService {
    @Autowired
    private PosterRecommendRecommendTemplateDAO posterRecommendRecommendTemplateDAO;
    @Autowired
    private PosterTemplateCategoryDAO posterTemplateCategoryDAO;
    @Autowired
    private PosterTemplateTopicDAO posterTemplateTopicDAO;
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
    public Page<PosterTemplate> paginatePosterTemplates(List<Integer> topicIds, List<Integer> categoryIds,
                                                        int pageNum, int pageSize) {
        PosterTemplateQueryRequest request = new PosterTemplateQueryRequest();
        request.setTopicIds(topicIds);
        request.setCategoryIds(categoryIds);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        PosterTemplateQueryResponse response = posterTemplateClient.queryTemplates(request);
        if (null == response || null == response.getPosterTemplatePage()) {
            return Page.empty();
        } else {
            return response.getPosterTemplatePage();
        }
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

    public void favoriteTemplate(Long templateId) {
        posterTemplateClient.favoriteTemplate(templateId, 1);
    }
}
