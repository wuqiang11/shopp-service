package com.shopping.entity;

import java.io.Serializable;

public class UseValidateCodeBean implements Serializable {

    // ID
    private Long id;

    // 手机号
    private String phone;

    // 0未使用 1已使用
    private Long useStatus;


    private String overTime;

    private String createTime;

    private String udpateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Long useStatus) {
        this.useStatus = useStatus;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUdpateTime() {
        return udpateTime;
    }

    public void setUdpateTime(String udpateTime) {
        this.udpateTime = udpateTime;
    }

    @Override
    public String toString() {
        return "UseValidateCodeBean{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", useStatus=" + useStatus +
                ", overTime='" + overTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", udpateTime='" + udpateTime + '\'' +
                '}';
    }
}
