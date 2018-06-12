package com.onlineshop.web.admin;

import com.alibaba.fastjson.JSONObject;
import com.onlineshop.entity.Classify;
import com.onlineshop.service.AdminService;
import com.onlineshop.service.ClassifyService;
import com.onlineshop.service.OrdersService;
import com.onlineshop.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员控制层
 *
 * @author kaizhang
 * @create 2018-05-09 0:04
 **/
@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    ClassifyService classifyService;
    @Autowired
    AdminService adminService;

    /**
     * 用户注册页
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    /**
     * 订单页跳转
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView order(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/order");
        return modelAndView;
    }

    /**
     * 管理员登录页跳转
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/loginPage");
        return modelAndView;
    }

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam("adminName") String adminName,@RequestParam("adminPass") String adminPass){
        ModelAndView modelAndView = new ModelAndView();
        if(adminService.adminLoin(adminName,adminPass)){
            modelAndView.setViewName("admin/index");
        }
        return modelAndView;
    }

    /**
     * 父分类页跳转
     * @return
     */
    @RequestMapping(value = "/classifyp", method = RequestMethod.GET)
    public ModelAndView classifyp(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/classifyp");
        return modelAndView;
    }

    /**
     * 子分类页跳转
     * @return
     */
    @RequestMapping(value = "/classifyc", method = RequestMethod.GET)
    public ModelAndView classifyc(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/classifyc");
        return modelAndView;
    }

    /**
     * 新建分类页跳转
     * @return
     */
    @RequestMapping(value = "/new/classify/page", method = RequestMethod.GET)
    public ModelAndView newClassify(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/newclassify");
        return modelAndView;
    }

    /**
     * 查询所有订单信息
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/msg", method = RequestMethod.POST)
    public  JSONObject orderMsg(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",ordersService.orderCount());
        jsonObject.put("data",ordersService.selectOrderMsgList(page,limit));
        return jsonObject;
    }


    /**
     * 变更订单状态
     * @param orderId 要变更的订单id
     * @param status 要变为的状态
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/delivery", method = RequestMethod.POST)
    public  JSONObject orderMsg(@RequestParam("orderId") String orderId,@RequestParam("status") Integer status){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        if(ordersService.updateStatus(orderId,status)>0){
            jsonObject.put("code",1);
        }

        return  jsonObject;
    }

    /**
     * 删除订单
     * @param orderId 要删除的订单id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/delete", method = RequestMethod.POST)
    public  JSONObject orderDelete(@RequestParam("orderId") String orderId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        if(ordersService.deleteOrder(orderId)>0){
            jsonObject.put("code",1);
        }
        return  jsonObject;
    }


    /**
     * 新建分类
     * @param classifyName 分类名
     * @param classifyPid 父分类id
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/classify/new", method = RequestMethod.POST)
    public  JSONObject newClassify(@RequestParam("classifyName") String classifyName,String classifyPid){
        Classify classify = new Classify();
        int result = 0;
        if( StringUtils.isEmpty(classifyPid)){
            //设置为父分类
            classify.setClassifyPid("0");
            classify.setClassifyName(classifyName);
            classify.setClassifyId(CommonUtils.uuid());
            result = classifyService.insertNewClassify(classify);
        }else {
            //设置为子分类
            classify.setClassifyId(CommonUtils.uuid());
            classify.setClassifyName(classifyName);
            classify.setClassifyPid(classifyPid);
            result = classifyService.insertNewClassify(classify);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",result);
        return jsonObject;
    }


    /**
     * 删除分类
     * @param classifyId 要删除的分类id
     * @return 删除条数
     */
    @ResponseBody
    @RequestMapping(value = "/classify/delete", method = RequestMethod.POST)
    public  JSONObject deleteClassify(@RequestParam("classifyId") String classifyId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",classifyService.deleteClassify(classifyId));
        return  jsonObject;
    }


    /**
     * 修改分类
     * @param classifyId 要修改的分类id
     * @param classifyName 要修改为的分类名
     * @return json对象
     */
    @ResponseBody
    @RequestMapping(value = "/classify/change", method = RequestMethod.POST)
    public  JSONObject updateClassify(@RequestParam("classifyId") String classifyId,@RequestParam("classifyName") String classifyName){
        Classify classify = new Classify();
        classify.setClassifyId(classifyId);
        classify.setClassifyName(classifyName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",classifyService.updateClassify(classify));
        return  jsonObject;
    }


    /**
     * 获取父分类列表
     * @param page 分页当前页
     * @param limit 每页记录数
     * @return json对象
     */
    @ResponseBody
    @RequestMapping(value = "/classify/plist", method = RequestMethod.POST)
    public  JSONObject parentClassifyList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",classifyService.countClassifyP());
        jsonObject.put("data",classifyService.selectClassifyParent(page,limit));
        return  jsonObject;
    }


    /**
     * 获取子分类列表
     * @param page 分页当前页
     * @param limit 每页记录数
     * @return json对象
     */
    @ResponseBody
    @RequestMapping(value = "/classify/clist", method = RequestMethod.POST)
    public  JSONObject childrenClassifyList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",classifyService.countClassifyC());
        jsonObject.put("data",classifyService.selectAllChildClassifys(page,limit));
        return  jsonObject;
    }
}
