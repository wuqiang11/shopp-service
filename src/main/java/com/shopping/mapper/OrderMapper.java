package com.shopping.mapper;


import com.shopping.entity.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {


    /**
     * 查询订单列表
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<OrderBean> selectOrderList(@Param("pageNumber") Long pageNumber, @Param("pageSize") Long pageSize);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    public OrderBean selectOrderDetail(@Param("orderId") Long orderId);
}
