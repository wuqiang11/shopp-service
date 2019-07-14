package com.shopping.vo;

import java.io.Serializable;

public class GetShareLinkRespVo implements Serializable {

    private Long userId;

    private String avatar;

    private String shareLinkUrl;

    private String shareLinkRule;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getShareLinkUrl() {
        return shareLinkUrl;
    }

    public void setShareLinkUrl(String shareLinkUrl) {
        this.shareLinkUrl = shareLinkUrl;
    }

    public String getShareLinkRule() {
        return shareLinkRule;
    }

    public void setShareLinkRule(String shareLinkRule) {
        this.shareLinkRule = shareLinkRule;
    }

    @Override
    public String toString() {
        return "GetShareLinkRespVo{" +
                "userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", shareLinkUrl='" + shareLinkUrl + '\'' +
                ", shareLinkRule='" + shareLinkRule + '\'' +
                '}';
    }
}
