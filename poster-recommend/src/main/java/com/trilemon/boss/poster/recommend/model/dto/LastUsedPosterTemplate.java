package com.trilemon.boss.poster.recommend.model.dto;

import com.trilemon.boss.poster.template.model.PosterTemplate;

import java.util.Date;

/**
 * @author kevin
 */
public class LastUsedPosterTemplate {
    private PosterTemplate posterTemplate;
    private Date lastUsedTime;

    public PosterTemplate getPosterTemplate() {
        return posterTemplate;
    }

    public void setPosterTemplate(PosterTemplate posterTemplate) {
        this.posterTemplate = posterTemplate;
    }

    public Date getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(Date lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }
}
