package com.trilemon.boss.poster.template.client;

import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.model.PosterTemplate;

/**
 * @author kevin
 */
public interface PosterTemplateClient {
    PosterTemplate getPosterTemplate(Long templateId);

    PosterTemplateQueryResponse queryTemplates(PosterTemplateQueryRequest request);
}
