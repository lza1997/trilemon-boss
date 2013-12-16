package com.trilemon.boss.poster.template.client.impl;

import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.boss.poster.template.service.TemplateService;

/**
 * @author kevin
 */
public class PosterTemplateClientImpl implements PosterTemplateClient {
    private TemplateService templateService;

    public void setTemplateService(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Override
    public PosterTemplate getPosterTemplate(Long templateId) {
        return templateService.getTemplate(templateId);
    }

    @Override
    public PosterTemplateQueryResponse queryTemplates(PosterTemplateQueryRequest request) {
        return templateService.queryTemplates(request);
    }


    public TemplateService getTemplateService() {
        return templateService;
    }
}
