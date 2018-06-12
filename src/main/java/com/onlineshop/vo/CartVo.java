package com.onlineshop.vo;

import com.onlineshop.dto.CartItemDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车视图对象
 *
 * @author kaizhang
 * @create 2018-05-04 15:28
 **/

public class CartVo {
    private List<CartItemDto> cartItemDtos;
    private BigDecimal allSubTotal;

    public CartVo() {
    }

    public CartVo(List<CartItemDto> cartItemDtos, BigDecimal allSubTotal) {
        this.cartItemDtos = cartItemDtos;
        this.allSubTotal = allSubTotal;
    }

    public List<CartItemDto> getCartItemDtos() {
        return cartItemDtos;
    }

    public void setCartItemDtos(List<CartItemDto> cartItemDtos) {
        this.cartItemDtos = cartItemDtos;
    }

    public BigDecimal getAllSubTotal() {
        return allSubTotal;
    }

    public void setAllSubTotal(BigDecimal allSubTotal) {
        this.allSubTotal = allSubTotal;
    }
}
