package com.onlineshop.dao;

import com.onlineshop.dto.CartItemDto;
import com.onlineshop.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {
    int deleteByPrimaryKey(String cartId);

    /**
     * 根据用户id,图书id 删除属于该用户的该图书的购物车条目记录
     * @param userId
     * @param bookId
     * @return
     */
    int deleteByUidAndBid(@Param("userId")String userId,@Param("bookId")Integer bookId);


    /**
     * 全属性插入
     * @param record
     * @return
     */
    int insert(Cart record);

    /**
     * 部分属性插入
     * @param record
     * @return
     */
    int insertSelective(Cart record);

    /**
     * 根据主键查询记录
     * @param cartId
     * @return
     */
    Cart selectByPrimaryKey(String cartId);


    /**
     * 根据用户id查询购物车
     * @param userId
     * @return
     */
    List<CartItemDto> selectByUserId(String userId);

    /**
     * 根据主键更新选择部分
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * 根据主键更新整条记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Cart record);


    /**
     * 根据用户id,图书id
     * 查询记录
     * @param userId
     * @param bookId
     * @return
     */
    Cart queryByUidAndBid(@Param("userId")String userId,@Param("bookId")Integer bookId);


    /**
     * 更新指定用户id,图书id记录的bookNum
     * @param userId
     * @param bookId
     * @return
     */
    int updateByUidAndBid(@Param("userId")String userId,@Param("bookId")Integer bookId);
}