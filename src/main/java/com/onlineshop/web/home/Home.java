package com.onlineshop.web.home;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.onlineshop.entity.Book;
import com.onlineshop.entity.Classify;
import com.onlineshop.service.BookService;
import com.onlineshop.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 主页
 *
 * @author kaizhang
 * @create 2018-03-28 16:37
 **/
@Controller
@RequestMapping("/index")
public class Home {
    @Autowired
    ClassifyService classifyService;
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        List<Classify> classifies = classifyService.selectAllClassifys();
        modelAndView.addObject("classifies",classifies);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    /**
     * 测试页面
     * @return
     */
    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testPage");
        return modelAndView;
    }

    /**
     * 获取指定页的图书列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bookList",method = RequestMethod.POST)
    public Object bookList(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        if(pageNum!=null&pageSize!=null) return bookService.queryAllBook(pageNum, pageSize);
        return null;
    }
}
