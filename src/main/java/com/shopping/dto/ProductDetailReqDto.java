package com.shopping.dto;

import java.io.Serializable;

public class ProductDetailReqDto implements Serializable {

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDetailReqDto{" +
                "productId=" + productId +
                '}';
    }
}
