package com.trilemon.boss.poster.template.client.response;

import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;

/**
 * @author kevin
 */
public class PosterTemplateQueryResponse {
    private long queryTime;
    private Page<PosterTemplate> posterTemplatePage;

    public long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(long queryTime) {
        this.queryTime = queryTime;
    }

    public Page<PosterTemplate> getPosterTemplatePage() {
        return posterTemplatePage;
    }

    public void setPosterTemplatePage(Page<PosterTemplate> posterTemplatePage) {
        this.posterTemplatePage = posterTemplatePage;
    }
}
