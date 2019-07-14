package com.shopping.entity;

import java.io.Serializable;

public class ProductBean implements Serializable {

    private Long id;

    private String name;

    private String caption;

    private String thumbnail;

    private String introduction;

    private Long productCategoryId;

    private String sn;

    private String sales;

    private Double price;

    private Double marketPrice;

    private Long stock;

    private String parameterValue;

    private Long sortNum;

    private Long isRecommend;

    private Double superiorRebateMoney;

    private String rebateRule;

    private Long productLabel;

    private Long productType;

    private Long productProperty;

    private Long extractType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Long getSortNum() {
        return sortNum;
    }

    public void setSortNum(Long sortNum) {
        this.sortNum = sortNum;
    }

    public Long getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Double getSuperiorRebateMoney() {
        return superiorRebateMoney;
    }

    public void setSuperiorRebateMoney(Double superiorRebateMoney) {
        this.superiorRebateMoney = superiorRebateMoney;
    }

    public String getRebateRule() {
        return rebateRule;
    }

    public void setRebateRule(String rebateRule) {
        this.rebateRule = rebateRule;
    }

    public Long getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(Long productLabel) {
        this.productLabel = productLabel;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Long getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(Long productProperty) {
        this.productProperty = productProperty;
    }

    public Long getExtractType() {
        return extractType;
    }

    public void setExtractType(Long extractType) {
        this.extractType = extractType;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", introduction='" + introduction + '\'' +
                ", productCategoryId=" + productCategoryId +
                ", sn='" + sn + '\'' +
                ", sales='" + sales + '\'' +
                ", price=" + price +
                ", marketPrice=" + marketPrice +
                ", stock=" + stock +
                ", parameterValue='" + parameterValue + '\'' +
                ", sortNum=" + sortNum +
                ", isRecommend=" + isRecommend +
                ", superiorRebateMoney=" + superiorRebateMoney +
                ", rebateRule='" + rebateRule + '\'' +
                ", productLabel=" + productLabel +
                ", productType=" + productType +
                ", productProperty=" + productProperty +
                ", extractType=" + extractType +
                '}';
    }
}
