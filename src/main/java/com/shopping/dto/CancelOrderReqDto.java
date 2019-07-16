package com.shopping.dto;

import net.sf.oval.constraint.MemberOf;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

public class CancelOrderReqDto implements Serializable {

    @NotNull(errorCode = "1001", message = "订单ID不能为空")
    private Long orderId;

    @NotNull(errorCode = "1001", message = "操作类型")
    @MemberOf(value = {"1", "2", "3"}, errorCode = "1001", message = "操作类型未定义")
    public Long handleType;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getHandleType() {
        return handleType;
    }

    public void setHandleType(Long handleType) {
        this.handleType = handleType;
    }

    @Override
    public String toString() {
        return "CancelOrderReqDto{" +
                "orderId=" + orderId +
                ", handleType=" + handleType +
                '}';
    }
}
