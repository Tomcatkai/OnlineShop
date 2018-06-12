package com.onlineshop.service;

import com.onlineshop.dao.CartDao;
import com.onlineshop.dto.CartItemDto;
import com.onlineshop.entity.Cart;
import com.onlineshop.utils.CommonUtils;
import com.onlineshop.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车相关业务
 *
 * @author kaizhang
 * @create 2018-04-30 17:09
 **/
@Service
public class CartService {
    @Autowired
    CartDao cartDao;

    /**
     * 使用用户id查询属于该用户的购物车条目集合
     *
     * @param userId
     * @return
     */
    public CartVo queryByUserId(String userId) {
        CartVo cartVo = new CartVo();
        List<CartItemDto> cartItemDtos = cartDao.selectByUserId(userId);
        BigDecimal allSubTotal = new BigDecimal("0");
        for (CartItemDto cartItemDto : cartItemDtos) {
            BigDecimal bookPrice = BigDecimal.valueOf(cartItemDto.getBookPriceCurrent());//图书单价
            BigDecimal bookNum = BigDecimal.valueOf(cartItemDto.getCartBookNum());//图书数量
            BigDecimal colSubTotal = bookPrice.multiply(bookNum);//单列总价
            cartItemDto.setColSubTotal(colSubTotal);
            allSubTotal = allSubTotal.add(colSubTotal);//单列总价之和
        }
        cartVo.setAllSubTotal(allSubTotal);//vo中设置总价格
        cartVo.setCartItemDtos(cartItemDtos);
        return cartVo;
    }


    /**
     * 加入图书进入购物车
     * 使用用户id和图书id查询是否有记录,没有记录就添加新记录,若有记录则进行更新记录
     *
     * @param userId
     * @param bookId
     * @param addNum
     * @return
     */
    public int AddBookToCart(String userId, Integer bookId, Integer addNum) {
        /*
         1.首先通过用户id和图书id查询用户是否已将该图书添加过了购物车
         */
        Cart cart = cartDao.queryByUidAndBid(userId, bookId);
        int result = 0;
        if (cart != null && cart.getCartId() != null && cart.getCartBookNum() != null && addNum != null) {
           /*
           2.若已添加过购物车则计算后更新该条记录中的图书数量
            */
            int formerNum = cart.getCartBookNum();
            int plusNum = addNum;
            int resultCount = formerNum + plusNum;
            Cart resultCart = new Cart();
            resultCart.setCartId(cart.getCartId());
            resultCart.setCartBookNum(resultCount);
            result = cartDao.updateByPrimaryKeySelective(resultCart);
        } else if (bookId != null && addNum != null) {
           /*
             3.若未添加过购物车则添加新记录
            */
            String id = CommonUtils.uuid();
            Cart resultCart = new Cart();
            resultCart.setCartBookNum(addNum);
            resultCart.setCartId(id);
            resultCart.setCartUid(userId);
            resultCart.setCartBookId(bookId);
            result = cartDao.insert(resultCart);
        }
         /*
           4.操作完成后返回操作结果
         */
        return result;
    }

    /**
     * 删除购物车条目
     *
     * @param userId
     * @param bookId
     * @return
     */
    public int deleteCartItem(String userId, Integer bookId) {
        return cartDao.deleteByUidAndBid(userId, bookId);
    }

    /**
     * 添加购物车中图书数量或减少购物车中图书数量
     *
     * @param userId
     * @param bookId
     * @param flag
     * @return
     */
    public int AddOrReduceBookNum(String userId, Integer bookId, boolean flag) {
        /*
        1.通过userId,bokId查询购物车记录
        2.若有记录,则判断flag,flag: true 添加,flag: false 减少;    对应进行操作,计算后构建cart对象进行更新表记录,返回操作记录数
        3.若无记录,返回0
         */
        Cart cart = cartDao.queryByUidAndBid(userId, bookId);
        int result = 0;
        if (cart != null && cart.getCartId() != null && cart.getCartBookNum() != null) {
            int bookNum = cart.getCartBookNum();
            if (flag) {
                bookNum = bookNum + 1;
                cart.setCartBookNum(bookNum);
            } else {
                if (bookNum >= 2) {
                    bookNum = bookNum - 1;
                    cart.setCartBookNum(bookNum);
                }
            }
            result = cartDao.updateByPrimaryKey(cart);
        }
        return result;
    }

}
