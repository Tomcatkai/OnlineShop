package com.onlineshop.dao;

import com.onlineshop.dto.OrderItemMsgDto;
import com.onlineshop.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDao {
    int deleteByPrimaryKey(String orderItemId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String orderItemId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**
     * 查询某条订单下的订单条目详细信息
     * @param orderId
     * @return
     */
    List<OrderItemMsgDto> selectOrderItems(String orderId);
}