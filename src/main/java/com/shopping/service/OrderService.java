package com.shopping.service;

import com.shopping.constants.BaseRespConstants;
import com.shopping.dto.CancelOrderReqDto;
import com.shopping.dto.OrderDetailReqDto;
import com.shopping.dto.OrderListReqDto;
import com.shopping.entity.OrderBean;
import com.shopping.entity.SuccessTip;
import com.shopping.entity.Tip;
import com.shopping.exception.BussinessException;
import com.shopping.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:  OrderService
 * Description:
 * date:  2019/7/15 0015  16:36
 *
 * @author wuqiang
 * @version 1.0
 */
@Service
public class OrderService extends BaseService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 订单列表
     *
     * @param reqDto
     * @return
     */
    public Tip orderList(OrderListReqDto reqDto) {

        Long startIndex = (reqDto.getPageNumber() - 1) * reqDto.getPageSize();
        Long endIndex = reqDto.getPageSize();
        List<OrderBean> list = orderMapper.selectOrderList(startIndex, endIndex, reqDto.getOrderStatus());
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), list);
    }

    /**
     * 订单详情
     *
     * @param reqDto
     * @return
     */
    public Tip orderDetail(OrderDetailReqDto reqDto) {
        OrderBean orderBean = orderMapper.selectOrderDetail(reqDto.getOrderId());
        return new SuccessTip(BaseRespConstants.NEW_SUCCESS.getMsg(), orderBean);
    }

    @Transactional
    public Tip cancelOrDelOrder(CancelOrderReqDto reqDto) {
        int updateResult = 0;
        if (reqDto.getHandleType().intValue() == 1) {
            updateResult = orderMapper.cancelOrder(reqDto.getOrderId());
        } else if (reqDto.getHandleType().intValue() == 2) {
            updateResult = orderMapper.deleteOrder(reqDto.getOrderId());
        } else if (reqDto.getHandleType().intValue() == 3) {
            updateResult = orderMapper.confirmOrder(reqDto.getOrderId());
        }
        if (updateResult <= 0) {
            throw new BussinessException("操作失败");
        }
        return new SuccessTip();
    }
}
