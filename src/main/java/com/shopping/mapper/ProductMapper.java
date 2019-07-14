package com.shopping.mapper;

import com.shopping.entity.ProductBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    /**
     * 分页查询商品列表
     * @param productName
     * @param isRcommend
     * @param startIndex
     * @param endIndex
     * @return
     */
    public List<ProductBean> getProductList(@Param("productName") String productName, @Param("isRecommend") Long isRcommend, @Param("startIndex") Long startIndex, @Param("endIndex") Long endIndex);


    public ProductBean getProductById(@Param("id") Long id);
}
