package com.onlineshop.web.user;

import com.alibaba.fastjson.JSONObject;
import com.onlineshop.service.CartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 购物车相关Controller
 *
 * @author kaizhang
 * @create 2018-04-30 17:08
 **/
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    /**
     * 购物车详情页面获取数据及跳转
     *
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView cartDetail(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String userId = (String) session.getAttribute("userId");
        if (StringUtils.isNotEmpty(userId)) {
            modelAndView.addObject("cartVo", cartService.queryByUserId(userId));
            modelAndView.setViewName("cart");
        }else{
            String msg = "您尚未登录，请登录后查看购物车！谢谢合作！";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("msg");
        }
        return modelAndView;
    }

    /**
     * 添加图书进入购物车,即添加购物车条目
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add/{bookId}", method = {RequestMethod.POST})
    public JSONObject addCart(HttpSession session, @PathVariable("bookId") Integer bookId, @RequestParam("bookNum") Integer bookNum) {
        JSONObject jsonObject = new JSONObject();
        String userId = (String) session.getAttribute("userId");
        if(userId == null){
            String msg = "您未登录,请登录后再添加购物车!";
            jsonObject.put("code",0);
            jsonObject.put("msg",msg);
            return jsonObject;
        }
        int result =  cartService.AddBookToCart(userId,bookId,bookNum);
        if(result>0){
            jsonObject.put("code",1);
            jsonObject.put("result","/cart/detail.html");
        }
        return jsonObject;
    }

    /**
     * 删除购物车条目
     * @param session
     * @param bookId
     * @return
     */
    @RequestMapping(value = "/delete/{bookId}",method = RequestMethod.GET)
    public ModelAndView deleteCartItem(HttpSession session,@PathVariable("bookId") Integer bookId){
        ModelAndView modelAndView = new ModelAndView();
        String userId = (String) session.getAttribute("userId");
        if(userId == null){
            String msg = "您未登录,请登录后再删除购物车条目!";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("msg");
            return modelAndView;
        }
        cartService.deleteCartItem(userId,bookId);
        modelAndView.setViewName("redirect:/cart/detail.html");
        return modelAndView;
    }

    /**
     *修改图书数量
     * @param session
     * @param bookId
     * @param flag
     * @return
     */
    @RequestMapping(value = "/change/{bookId}",method = RequestMethod.GET)
    public ModelAndView changeBookNum(HttpSession session,@PathVariable("bookId") Integer bookId,boolean flag){
        ModelAndView modelAndView = new ModelAndView();
        String userId = (String) session.getAttribute("userId");
        if(userId == null){
            String msg = "您未登录,请登录后再修改购物车条目!";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("msg");
            return modelAndView;
        }
        cartService.AddOrReduceBookNum(userId,bookId,flag);
        modelAndView.setViewName("redirect:/cart/detail.html");
        return modelAndView;
    }

}
