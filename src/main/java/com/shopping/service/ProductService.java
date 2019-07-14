package com.shopping.service;

import com.shopping.constants.BaseRespConstants;
import com.shopping.dto.ProductDetailReqDto;
import com.shopping.dto.ProductListReqDto;
import com.shopping.entity.ProductBean;
import com.shopping.entity.SuccessTip;
import com.shopping.entity.Tip;
import com.shopping.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService extends BaseService {

    @Resource
    private ProductMapper productMapper;

    public Tip productList(ProductListReqDto reqDto) {
        Long startIndex = (reqDto.getPageNumber() - 1) * reqDto.getPageSize();
        Long endIndex = reqDto.getPageSize();
        List<ProductBean> productBeanList = productMapper.getProductList(reqDto.getProductName(), reqDto.getIsRecommend(), startIndex, endIndex);
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), productBeanList);
    }


    public Tip productDetail(ProductDetailReqDto reqDto)
    {
        ProductBean productBean = productMapper.getProductById(reqDto.getProductId());
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), productBean);
    }
}
