package com.shopping.controller;

import com.shopping.dto.ProductDetailReqDto;
import com.shopping.dto.ProductListReqDto;
import com.shopping.entity.Tip;
import com.shopping.service.ProductService;
import com.shopping.util.OvalValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 商品列表
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/product/productlist")
    @ResponseBody
    public Tip productList(ProductListReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return  productService.productList(reqDto);
    }

    /**
     * 商品详情
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/product/productDetail")
    @ResponseBody
    public Tip productDetail(ProductDetailReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return productService.productDetail(reqDto);
    }
}
