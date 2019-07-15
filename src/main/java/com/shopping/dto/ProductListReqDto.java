package com.shopping.dto;

import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

public class ProductListReqDto implements Serializable {

    private String productName;

    private Long isRecommend;

    @NotNull(message = "当前页数不能为空", errorCode = "1001")
    private Long pageNumber;

    @NotNull(message = "每页条数不能为空", errorCode = "1001")
    private Long pageSize;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ProductListReqDto{" +
                "productName='" + productName + '\'' +
                ", isRecommend=" + isRecommend +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
