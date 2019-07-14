package com.shopping.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InviationRegReqDto implements Serializable {

    @NotNull(message = "邀请用户ID不能为空")
    private Long inviateUserId;

    @NotNull(message = "手机号不能为空")
    private String phone;

    @NotNull(message = "验证码不能为空")
    private String code;

    public Long getInviateUserId() {
        return inviateUserId;
    }

    public void setInviateUserId(Long inviateUserId) {
        this.inviateUserId = inviateUserId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "InviationRegReqDto{" +
                "inviateUserId=" + inviateUserId +
                ", phone=" + phone +
                ", code='" + code + '\'' +
                '}';
    }
}
