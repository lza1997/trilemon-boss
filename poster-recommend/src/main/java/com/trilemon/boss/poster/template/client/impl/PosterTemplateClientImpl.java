package com.trilemon.boss.poster.template.client.impl;

import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.boss.poster.template.service.TemplateService;

import java.util.List;

/**
 * @author kevin
 */
public class PosterTemplateClientImpl implements PosterTemplateClient {
    private TemplateService templateService;

    @Override
    public PosterTemplate getPosterTemplate(Long templateId) {
        return templateService.getTemplate(templateId);
    }

    @Override
    public List<PosterTemplate> getPosterTemplates(List<Long> templateIds) {
        return templateService.getTemplates(templateIds);
    }

    @Override
    public PosterTemplateQueryResponse queryTemplates(PosterTemplateQueryRequest request) {
        return templateService.queryTemplates(request);
    }

    @Override
    public void favoriteTemplate(Long templateId, int favoriteNum) {
        templateService.favorite(templateId, favoriteNum);
    }

    public TemplateService getTemplateService() {
        return templateService;
    }

    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }
}
