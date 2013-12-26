package com.trilemon.boss.poster.template.client;

import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.model.PosterTemplate;

import java.util.List;

/**
 * @author kevin
 */
public interface PosterTemplateClient {
    PosterTemplate getPosterTemplate(Long templateId);
    List<PosterTemplate> getPosterTemplates(List<Long> templateIds);

    PosterTemplateQueryResponse queryTemplates(PosterTemplateQueryRequest request);

    void favoriteTemplate(Long templateId,int favoriteNum);
}
