package com.shopping.dto;

import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

public class ProductDetailReqDto implements Serializable {

    @NotNull(errorCode = "1001",message = "商品ID不能为空")
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
