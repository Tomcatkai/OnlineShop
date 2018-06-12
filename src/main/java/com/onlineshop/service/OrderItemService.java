package com.onlineshop.service;

import com.onlineshop.dao.OrderItemDao;
import com.onlineshop.dto.OrderItemMsgDto;
import com.onlineshop.vo.OrderItemMsgVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单条目业务相关
 *
 * @author kaizhang
 * @create 2018-05-10 16:52
 **/
@Service
public class OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;

    /**
     * 查询指定订单id 下的所有订单条目信息
     * @param orderId
     * @return
     */
    public List<OrderItemMsgVo> queryOrderItemMsg(String orderId){
        List<OrderItemMsgDto> orderItemMsgDtos = orderItemDao.selectOrderItems(orderId);
        List<OrderItemMsgVo> orderItemMsgVos = new ArrayList<OrderItemMsgVo>();
        for (OrderItemMsgDto orderItemMsgDto : orderItemMsgDtos){
            OrderItemMsgVo orderItemMsgVo = new OrderItemMsgVo();
            BeanUtils.copyProperties(orderItemMsgDto,orderItemMsgVo);
            BigDecimal bookPrice = BigDecimal.valueOf(orderItemMsgDto.getBookPriceCurrent());//图书单价
            BigDecimal bookNum = BigDecimal.valueOf((int)orderItemMsgDto.getBookNum());
            BigDecimal result = bookPrice.multiply(bookNum);
            orderItemMsgVo.setTotalPrice(result);
            orderItemMsgVos.add(orderItemMsgVo);
        }
        return orderItemMsgVos;
    }
}
