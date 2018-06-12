package com.onlineshop.dao;

import com.onlineshop.dto.OrderMsgDto;
import com.onlineshop.dto.OrderMsgListDto;
import com.onlineshop.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    int deleteByPrimaryKey(String orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 使用用户id 查询该用户的所有订单信息
     * @param userId 用户id
     * @return 订单信息list
     */
    List<OrderMsgDto> selectOrderMsgByUser(String userId);

    /**
     * 管理员
     * 请求订单信息列表
     * @return
     */
    List<OrderMsgListDto> selectOrderMsgList();

    /**
     * 返回订单总记录数
     * @return
     */
    int orderCount();




}