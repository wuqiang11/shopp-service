package com.shopping.dto;

import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * ClassName:  OrderDetailReqDto
 * Description:
 * date:  2019/7/15 0015  16:30
 *
 * @author wuqiang
 * @version 1.0
 */
public class OrderDetailReqDto implements Serializable {

    @NotNull(message = "订单ID不能为空",errorCode = "1001")
    private  Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailReqDto{" +
                "orderId=" + orderId +
                '}';
    }
}
