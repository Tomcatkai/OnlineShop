package com.onlineshop.service;

import com.github.pagehelper.PageHelper;
import com.onlineshop.dao.CartDao;
import com.onlineshop.dao.OrderItemDao;
import com.onlineshop.dao.OrdersDao;
import com.onlineshop.dto.CartItemDto;
import com.onlineshop.dto.OrderMsgDto;
import com.onlineshop.dto.OrderMsgListDto;
import com.onlineshop.entity.OrderItem;
import com.onlineshop.entity.Orders;
import com.onlineshop.utils.CommonUtils;
import com.onlineshop.vo.CartVo;
import com.onlineshop.vo.OrderMsgListVo;
import com.onlineshop.vo.UserOrderMsgVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单业务相关
 *
 * @author kaizhang
 * @create 2018-05-06 23:07
 **/
@Service
public class OrdersService {
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    CartDao cartDao;

    /**
     * 新建订单
     *
     * @param cartVo
     * @param addressId
     * @param userId
     */
    public void createOrder(CartVo cartVo, String addressId, String userId) {
        /*
        1.构建order对象
        2.构建orderItem对象
        3.将order,orderItem对象存入数据库
        4.删除购物车中对应的项
        5.返回成功记录
         */
        Orders orders = new Orders();
        String orderId = CommonUtils.uuid();
        orders.setOrderId(orderId);
        orders.setOrderAdressId(addressId);
        orders.setOrderStatus(0);
        Date date = new Date();
        orders.setOrderTime(date);
        orders.setOrderUid(userId);
        orders.setOrderTotal(cartVo.getAllSubTotal());
        ordersDao.insert(orders);

        List<CartItemDto> cartItemDtoList = cartVo.getCartItemDtos();
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBookId(cartItemDto.getCartBookId());
            orderItem.setBookNum(cartItemDto.getCartBookNum());
            orderItem.setOrderId(orderId);
            orderItem.setOrderItemId(CommonUtils.uuid());
            orderItemDao.insert(orderItem);
            cartDao.deleteByPrimaryKey(cartItemDto.getCartId());
        }
    }


    /**
     * 查询订单信息列表
     *
     * @return
     */
    public List<OrderMsgListVo> selectOrderMsgList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<OrderMsgListDto> listDtos = ordersDao.selectOrderMsgList();
        List<OrderMsgListVo> orderMsgListVoList = new ArrayList<OrderMsgListVo>();
        for (OrderMsgListDto orderMsgListDto : listDtos) {
            OrderMsgListVo orderMsgListVo = new OrderMsgListVo();
            BeanUtils.copyProperties(orderMsgListDto, orderMsgListVo);
            int status = orderMsgListDto.getOrderStatus();
            if (status == 0) {
                orderMsgListVo.setOrderStatus("未付款");
            } else if (status == 1) {
                orderMsgListVo.setOrderStatus("已支付");
            } else if (status == 2) {
                orderMsgListVo.setOrderStatus("已发货");
            } else if (status == 3) {
                orderMsgListVo.setOrderStatus("已完成");
            } else if (status == 4) {
                orderMsgListVo.setOrderStatus("已取消");
            }
            Date date = orderMsgListDto.getOrderTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String sdf = format.format(date);
            orderMsgListVo.setOrderTime(sdf);
            orderMsgListVoList.add(orderMsgListVo);
        }
        return orderMsgListVoList;
    }

    /**
     * @return 返回订单数量总数
     */
    public int orderCount() {
        return ordersDao.orderCount();
    }

    /**
     * 修改订单状态
     *
     * @param orderId
     * @return
     */
    public int updateStatus(String orderId, Integer status) {
        if (status != null) {
            Orders orders = ordersDao.selectByPrimaryKey(orderId);
            orders.setOrderStatus(status);
            return ordersDao.updateByPrimaryKeySelective(orders);
        }
        return 0;
    }

    /**
     * 删除指定订单
     * 订单只能删除已完成和已取消的订单,无法删除已支付1和已发货状态2的订单
     *
     * @param orderId
     * @return
     */
    public int deleteOrder(String orderId) {
        if (StringUtils.isNotEmpty(orderId)) {
            Orders orders = ordersDao.selectByPrimaryKey(orderId);
            assert orders != null;
            if (orders.getOrderStatus() != null && orders.getOrderStatus() > 2 || orders.getOrderStatus() == 0) {
                return ordersDao.deleteByPrimaryKey(orderId);
            }
        }
        return 0;
    }

    /**
     * 用户查询自己的订单列表
     *
     * @return
     */
    public List<UserOrderMsgVo> queryOrderMsg(String userId) {
        List<OrderMsgDto> orderMsgDtos = ordersDao.selectOrderMsgByUser(userId);
        List<UserOrderMsgVo> userOrderMsgVoList = new ArrayList<UserOrderMsgVo>();
        for (OrderMsgDto orderMsgDto : orderMsgDtos) {
            UserOrderMsgVo userOrderMsgVo = new UserOrderMsgVo();
            BeanUtils.copyProperties(orderMsgDto, userOrderMsgVo);
            int status = orderMsgDto.getOrderStatus();
            if (status == 0) {
                userOrderMsgVo.setOrderStatus("未付款");
            } else if (status == 1) {
                userOrderMsgVo.setOrderStatus("已支付");
            } else if (status == 2) {
                userOrderMsgVo.setOrderStatus("已发货");
            } else if (status == 3) {
                userOrderMsgVo.setOrderStatus("已完成");
            } else if (status == 4) {
                userOrderMsgVo.setOrderStatus("已取消");
            }
            Date date = orderMsgDto.getOrderTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String sdf = format.format(date);
            userOrderMsgVo.setOrderTime(sdf);
            userOrderMsgVoList.add(userOrderMsgVo);
        }
        return userOrderMsgVoList;
    }

}
