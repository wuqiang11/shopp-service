package com.shopping.controller;

import com.shopping.dto.CancelOrderReqDto;
import com.shopping.dto.OrderDetailReqDto;
import com.shopping.dto.OrderListReqDto;
import com.shopping.entity.Tip;
import com.shopping.service.OrderService;
import com.shopping.util.OvalValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  OrderController
 * Description:
 * date:  2019/7/15 0015  16:35
 *
 * @author wuqiang
 * @version 1.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param reqDto
     * @return
     */
    @RequestMapping("/api/order/orderlist")
    @ResponseBody
    public Tip orderList(OrderListReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return orderService.orderList(reqDto);
    }

    /**
     *  订单详情
     * @param reqDto
     * @return
     */
    @RequestMapping(value = "/api/order/orderDetail",method = RequestMethod.POST)
    @ResponseBody
    public Tip orderDetail(OrderDetailReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return orderService.orderDetail(reqDto);
    }

    /**
     *  取消或者删除订单
     * @param reqDto
     * @return
     */
    @RequestMapping(value = "/api/order/cancelOrDelOrder",method = RequestMethod.POST)
    @ResponseBody
    public Tip cancelOrDelOrder(CancelOrderReqDto reqDto)
    {
        OvalValidationUtils.validate(reqDto);
        return orderService.cancelOrDelOrder(reqDto);
    }
}
