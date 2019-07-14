package com.shopping.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class GetShareLinkReqDto implements Serializable {

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GetShareLinkReqDto{" +
                "userId=" + userId +
                '}';
    }
}
