package com.trilemon.boss.poster.recommend.service;

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

import java.util.List;

/**
 * @author kevin
 */
public class RecommendActivityTemplateService {
    private PosterTemplateCategoryDAO posterTemplateCategoryDAO;
    private PosterTemplateTopicDAO posterTemplateTopicDAO;
    private List<PosterTemplateCategory> posterTemplateCategories;
    private List<PosterTemplateTopic> posterTemplateTopics;
    @Autowired
    private PosterTemplateClient posterTemplateClient;

    /**
     * 获取推荐模板
     *
     * @param userId
     * @return
     */
    public PosterTemplate getRecommendPosterTemplate(Long userId) {
        return null;
    }

    /**
     * 模板翻页
     *
     * @param userId
     * @param topicIds
     * @param categoryIds
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginatePosterTemplates(Long userId, List<String> topicIds, List<String> categoryIds,
                                                        int pageNum, int pageSize) {
        PosterTemplateQueryRequest request = new PosterTemplateQueryRequest();
        request.setTopics(topicIds);
        request.setCategories(categoryIds);
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
    private void refreshTemplateTopics() {
        posterTemplateTopics = posterTemplateTopicDAO.selectAll();
    }

    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void refreshTemplateCategories() {
        posterTemplateCategories = posterTemplateCategoryDAO.selectAll();
    }
}
