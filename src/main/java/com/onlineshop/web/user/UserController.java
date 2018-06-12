package com.onlineshop.web.user;

import com.alibaba.fastjson.JSONObject;
import com.onlineshop.dto.UserLoginDto;
import com.onlineshop.entity.User;
import com.onlineshop.service.UserOperationService;
import com.onlineshop.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 用户相关操作   登录，注册，激活
 *
 * @author kaizhang
 * @create 2018-03-28 16:16
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserOperationService userOperationService;

    /**
     * 用户登录页
     *
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/loginPage");
        return modelAndView;
    }

    /**
     * 用户登录操作
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, HttpSession session) {
        UserLoginDto userLoginDto = userOperationService.queryUserByLoginNameAndLoginPass(user);
        String msg = userLoginDto.getMsg();
        user = userLoginDto.getUser();
        ModelAndView modelAndView = new ModelAndView();
        if (msg.equals("登录成功")) {
            session.setAttribute("userName", user.getLoginName());
            session.setAttribute("userId", user.getUserId());
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("user/loginPage");
        return modelAndView;
    }

    /**
     * 用户退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    /**
     * 用户注册页
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/register");
        return modelAndView;
    }

    /**
     * 用户注册操作
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute User user) {
        userOperationService.userRegist(user);
        ModelAndView modelAndView = new ModelAndView("msg");
        modelAndView.addObject("msg", "注册成功,请前往您的邮箱激活账号");
        return modelAndView;
    }

    /**
     * ajax查询邮箱是否已注册
     */
    @ResponseBody
    @RequestMapping(value = "/email/check", method = {RequestMethod.POST})
    public JSONObject emailCheck(@RequestParam("email") String email) {
        JSONObject isRegisted = new JSONObject();
        boolean b = userOperationService.isEmailRegisted(email);
        isRegisted.put("result", b);
        return isRegisted;
    }

    /**
     * ajax查询用户名是否已注册
     */
    @ResponseBody
    @RequestMapping(value = "/username/check", method = {RequestMethod.POST})
    public JSONObject usernameCheck(@RequestParam("userName") String userName) {
        JSONObject isRegisted = new JSONObject();
        boolean b = userOperationService.isUserNameRegisted(userName);
        isRegisted.put("result", b);
        return isRegisted;
    }

    /**
     * 返回验证码图片
     *
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verify", method = {RequestMethod.GET})
    public byte[] verifyCode(HttpSession httpSession) {
        VerifyCode verifyCode = new VerifyCode();
        //获取一次性验证码
        BufferedImage image = verifyCode.getImage();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            VerifyCode.output(image, byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpSession.setAttribute("vCode", verifyCode.getText());
        return byteArrayOutputStream.toByteArray();
    }


    /**
     * 验证码ajax校验
     *
     * @param httpSession
     * @param inputCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verify/check", method = {RequestMethod.POST})
    public JSONObject verifyCheck(HttpSession httpSession, @RequestParam("inputCode") String inputCode) {
        //真实的验证码
        String vCode = (String) httpSession.getAttribute("vCode");
        boolean b = inputCode.equalsIgnoreCase(vCode);
        JSONObject result = new JSONObject();
        result.put("result", b);
        return result;
    }

    /**
     * 用户激活方法
     *
     * @param activateCode
     * @return
     */
    @RequestMapping(value = "/activate", method = {RequestMethod.GET})
    public ModelAndView activateUser(@RequestParam("activateCode") String activateCode) {
        String msg = userOperationService.activateUser(activateCode);
        ModelAndView modelAndView = new ModelAndView("msg");
        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

}
