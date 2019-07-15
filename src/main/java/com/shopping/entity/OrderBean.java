package com.shopping.entity;

import java.io.Serializable;

/**
 * ClassName:  OrderBean
 * Description:
 * date:  2019/7/15 0015  16:41
 *
 * @author wuqiang
 * @version 1.0
 */
public class OrderBean implements Serializable {

    private Long id;

    private Long userId;

    private String orderSN;

    private Long orderStatus;

    private Long paymentStatus;

    private Long shippingStatus;

    private String address;

    private Double totalPrice;

    private Double postFee;

    private Double payFee;

    private String youhuis;

    private String couponName;

    private Long couponMoney;

    private Long userCouponId;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public void setOrderSN(String orderSN) {
        this.orderSN = orderSN;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Long paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Long shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPostFee() {
        return postFee;
    }

    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public String getYouhuis() {
        return youhuis;
    }

    public void setYouhuis(String youhuis) {
        this.youhuis = youhuis;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Long couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Long getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Long userCouponId) {
        this.userCouponId = userCouponId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderSN='" + orderSN + '\'' +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", shippingStatus=" + shippingStatus +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                ", postFee=" + postFee +
                ", payFee=" + payFee +
                ", youhuis='" + youhuis + '\'' +
                ", couponName='" + couponName + '\'' +
                ", couponMoney=" + couponMoney +
                ", userCouponId=" + userCouponId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
