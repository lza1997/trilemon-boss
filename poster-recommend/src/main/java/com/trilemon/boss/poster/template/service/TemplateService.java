package com.trilemon.boss.poster.template.service;

import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.client.response.PosterTemplateQueryResponse;
import com.trilemon.boss.poster.template.dao.PosterTemplateDAO;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevin
 */
@Service
public class TemplateService {
    @Autowired
    private PosterTemplateDAO posterTemplateDAO;

    /**
     * 查询模板
     *
     * @param request
     * @return
     */
    public PosterTemplateQueryResponse queryTemplates(PosterTemplateQueryRequest request) {
        int templateCount = posterTemplateDAO.countByQueryRequest(request);
        List<PosterTemplate> templateList = posterTemplateDAO.paginateByQueryRequest(request);
        Page<PosterTemplate> page = Page.create(templateCount, request.getPageNum(), request.getPageSize(), templateList);
        PosterTemplateQueryResponse response = new PosterTemplateQueryResponse();
        response.setPosterTemplatePage(page);
        return response;
    }

    public PosterTemplate getTemplate(Long templateId) {
        return posterTemplateDAO.selectByPrimaryKey(templateId);
    }

    public void favorite(long templateId, int count) {
        posterTemplateDAO.updateFavoriteByPrimaryKey(templateId, count);
    }

    public List<PosterTemplate> getTemplates(List<Long> templateIds) {
        return posterTemplateDAO.selectByPrimaryKeys(templateIds);
    }
}
