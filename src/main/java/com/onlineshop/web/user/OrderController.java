package com.onlineshop.web.user;

import com.alibaba.fastjson.JSONObject;
import com.onlineshop.dto.CartItemDto;
import com.onlineshop.entity.Address;
import com.onlineshop.service.AddressService;
import com.onlineshop.service.CartService;
import com.onlineshop.service.OrderItemService;
import com.onlineshop.service.OrdersService;
import com.onlineshop.vo.CartVo;
import com.onlineshop.vo.OrderItemMsgVo;
import com.onlineshop.vo.UserOrderMsgVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单相关controller
 *
 * @author kaizhang
 * @create 2018-05-06 16:39
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    CartService cartService;
    @Autowired
    AddressService addressService;
    @Autowired
    OrderItemService orderItemService;

    /**
     * 订单核对页面
     * 这里由于时间原因暂时直接从购物车中获取相关数据,后期再进行优化,由
     * 购物车页面传数据过来进行操作.
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ModelAndView checkOrder(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String userId = (String) session.getAttribute("userId");
        if (StringUtils.isNotEmpty(userId)) {
            CartVo cartVo = cartService.queryByUserId(userId);
            modelAndView.addObject("cartVo",cartVo);
            session.setAttribute("cartVo",cartVo);
            modelAndView.setViewName("orderCheck");
        }else{
            String msg = "您尚未登录，请登录后再进行操作！谢谢合作！";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("msg");
        }
        return modelAndView;
    }

    /**
     * 订单详情页
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView orderDetail(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String userId = (String) session.getAttribute("userId");
        if (StringUtils.isNotEmpty(userId)) {
            List<UserOrderMsgVo> list = ordersService.queryOrderMsg(userId);
            modelAndView.addObject("list",list);
        }else {
            String msg = "您尚未登录，请登录后再进行操作！谢谢合作！";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("msg");
            return modelAndView;
        }
        modelAndView.setViewName("order");
        return modelAndView;
    }

    /**
     * 订单创建
     * 创建成功后跳转到成功页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JSONObject orderCreate(HttpSession session, String addressId){
        JSONObject jsonObject = new JSONObject();
        int code = 0;
        String userId = (String) session.getAttribute("userId");
        if (StringUtils.isNotEmpty(userId)) {
            CartVo cartVo = (CartVo) session.getAttribute("cartVo");
            ordersService.createOrder(cartVo,addressId,userId);
            session.removeAttribute("cartVo");
            code = 1;
        }else{
            String msg = "您尚未登录，请登录后再进行下单！谢谢合作！";
            jsonObject.put("msg",msg);
        }
        jsonObject.put("code",code);
        return jsonObject;
    }

    /**
     * 下单成功页面
     * @return
     */
    @RequestMapping(value = "/suc", method = RequestMethod.GET)
    public ModelAndView orderSuc(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderSuc");
        return modelAndView;
    }

    /**
     * 查询用户的所有收货地址
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addresslist", method = RequestMethod.POST)
    public List<Address> addressList(HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String userId = (String) session.getAttribute("userId");
        return addressService.queryAddressByUid(userId);
    }


    /**
     * 通过订单id查询该订单下所有订单条目信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/orderItems/msg", method = RequestMethod.POST)
    public List<OrderItemMsgVo> orderItemsMsg(HttpSession session, String orderId){
        JSONObject jsonObject = new JSONObject();
        String userId = (String) session.getAttribute("userId");
        return orderItemService.queryOrderItemMsg(orderId);
    }



    /**
     * 新建收货地址
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/newaddress", method = RequestMethod.POST)
    public JSONObject newAddress(HttpSession session,String addressReciver,String addressReceiverPhone, String addressDetail,String addressProvince,String addressCity,String addressArea){
        JSONObject jsonObject = new JSONObject();
        String userId = (String) session.getAttribute("userId");
        if(StringUtils.isNotEmpty(userId)){
            String addressId = addressService.createNewAddress(userId,addressReciver,addressReceiverPhone,addressDetail,addressProvince,addressCity,addressArea,false);
            jsonObject.put("code",1);
            jsonObject.put("addressId",addressId);
        }else {
            jsonObject.put("code",0);
            jsonObject.put("msg","您未登录,请登录后再进行操作哦!");
        }
        return jsonObject;
    }
}
