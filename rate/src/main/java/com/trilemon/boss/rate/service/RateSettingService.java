package com.trilemon.boss.rate.service;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.RateConstants;
import com.trilemon.boss.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.commons.redis.JedisTemplate;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author kevin
 */
@Service
public class RateSettingService {
    @Autowired
    private RateCommentSettingDAO rateCommentSettingDAO;
    @Autowired
    private JedisTemplate jedisTemplate;

    public void createRateSetting(Long userId, RateSetting rateSetting) {

    }

    public void expireUser(RateSetting rateSetting) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<String> getComments(Long userId) {
        List<String> commentContents = rateCommentSettingDAO.selectContentByUserIdAndStatus(userId,
                ImmutableList.of(RateConstants.RATE_COMMENT_SETTING_STATUS_VALID));

        if (CollectionUtils.isEmpty(commentContents)) {
            return RateConstants.DEFAULT_COMMENT_LIST;
        } else {
            return commentContents;
        }
    }

    public Set<String> getBlacklist(String nick) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
