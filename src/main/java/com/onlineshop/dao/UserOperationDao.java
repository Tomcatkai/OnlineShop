package com.onlineshop.dao;

import com.onlineshop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author kai
 */
@Repository
public interface UserOperationDao {
    /**
     * 查询email是否已注册
     * @param email
     * @return
     */
    Integer emailCheck(@Param("email") String email);

    /**
     * 查询用户名是否已注册
     * @param userName
     * @return
     */
    Integer userNameCheck(@Param("userName") String userName);

    /**
     * 插入用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 用户激活
     * @param activateCode
     * @return
     */
    Integer activateUser(@Param("activateCode") String activateCode);

    /**
     * 使用激活码查找用户
     * @param activateCode
     * @return
     */
    User findUserByActivationCode(@Param("activateCode") String activateCode);

    /**
     * 用户登录,使用用户名和密码查询用户
     * @param user
     * @return
     */
    User queryUserByLoginPassAndLoginName(User user);



}
