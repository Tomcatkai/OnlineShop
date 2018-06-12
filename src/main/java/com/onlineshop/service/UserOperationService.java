package com.onlineshop.service;


import com.onlineshop.dao.UserOperationDao;
import com.onlineshop.dto.UserLoginDto;
import com.onlineshop.entity.User;
import com.onlineshop.utils.CommonUtils;
import com.onlineshop.utils.mail.Mail;
import com.onlineshop.utils.mail.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;


/**
 * 用户相关服务
 *
 * @author kaizhang
 * @create 2018-04-05 16:52
 **/
@Service
public class UserOperationService {

@Autowired
UserOperationDao userOperationDao;

    /**
     * 校验邮箱
     * @param email
     * @return
     */
    public boolean isEmailRegisted(String email){
        Integer countNum = userOperationDao.emailCheck(email);
        return countNum > 0;
    }

    /**
     * 校验用户名是否已注册
     * @param userName
     * @return
     */
    public boolean isUserNameRegisted(String userName){
        Integer countNum = userOperationDao.userNameCheck(userName);
        return countNum > 0;
    }

    /**
     * 用户注册
     * @param user
     */
    public void userRegist(User user){
        /*
         * 1.用户数据补全
         */
        user.setUserId(CommonUtils.uuid());
        user.setStatus(false);
        user.setActivationCode(CommonUtils.uuid()+CommonUtils.uuid());
        /*
         * 2.插入数据库
         */
        userOperationDao.insertUser(user);
        /*
         * 3.发邮件
         */
        /*
         * 加载配置文件
         */
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("email_send.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 登录邮件服务器,获取session
         */
        String host = properties.getProperty("host");
        String name = properties.getProperty("username");
        String pass = properties.getProperty("password");
        Session session = MailUtils.createSession(host,name,pass);
        /*
        创建Mail对象
         */
        String from = properties.getProperty("from");
        String to = user.getEmail();
        String subject = properties.getProperty("subject");
        // MessageForm.format方法会把第一个参数中的{0},使用第二个参数来替换。
        // 例如MessageFormat.format("你好{0}, 你{1}!", "张三", "去死吧"); 返回“你好张三，你去死吧！”
        String content = MessageFormat.format(properties.getProperty("content"),user.getActivationCode());
        Mail mail = new Mail(from,to,subject,content);
        /*
        发送邮件
         */
        try {
            MailUtils.send(session,mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户激活码
     * @param activationCode
     * @return
     */
    public String activateUser(String activationCode){
       /*
       1.判断用户是否存在
       若存在,未激活 进行激活
        */
       User user = userOperationDao.findUserByActivationCode(activationCode);
       if(user!=null){
           if(user.getStatus()){
               return "您已激活,请去登录";
           }
           if(userOperationDao.activateUser(activationCode)>0){
               return  "恭喜您,激活成功,请去登录";
           }
       }
       return  "激活码无效";
    }

    /**
     * 校验用户是否注册并激活
     * @param
     * @return
     */
    public UserLoginDto queryUserByLoginNameAndLoginPass(User user){
        User resultUser =  userOperationDao.queryUserByLoginPassAndLoginName(user);
        String msg;
        if(resultUser!=null){
            if(resultUser.getStatus()){
                msg = "登录成功";
                return new UserLoginDto(msg,resultUser);
            }
            msg = "用户未激活";
            return new UserLoginDto(msg,resultUser);
        }
        msg = "用户名或密码错误";
        return new UserLoginDto(msg, null);
    }

}
