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
    public List<OrderBean> selectOrderList(@Param("pageNumber") Long pageNumber, @Param("pageSize") Long pageSize, @Param("orderStatus") Long orderStatus);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    public OrderBean selectOrderDetail(@Param("orderId") Long orderId);

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    public int cancelOrder(@Param("orderId") Long orderId);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    public int deleteOrder(@Param("orderId") Long orderId);

    /**
     * 确认收货
     * @param orderId
     * @return
     */
    public int confirmOrder(@Param("orderId") Long orderId);
}
