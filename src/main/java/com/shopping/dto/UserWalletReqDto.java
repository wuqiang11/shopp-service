package com.shopping.dto;

import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

public class UserWalletReqDto implements Serializable {

    @NotNull(errorCode = "1001",message = "用户ID不能为空")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserWalletReqDto{" +
                "userId=" + userId +
                '}';
    }
}
