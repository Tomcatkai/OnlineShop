package com.onlineshop.web.user;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.onlineshop.entity.Book;
import com.onlineshop.entity.Classify;
import com.onlineshop.service.BookService;
import com.onlineshop.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 图书模块相关操作
 *
 * @author kaizhang
 * @create 2018-04-12 23:07
 **/

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 图书详情页跳转
     * @return
     */
    @RequestMapping(value = "/detail/{bookId}",method = RequestMethod.GET)
    public ModelAndView bookDetail(@PathVariable("bookId") Integer bookId){
        //填充空数据
        ModelAndView modelAndView =  new ModelAndView("book");
        modelAndView.addObject("book",null);
        //填充图书数据
        if(bookId!=null){
         modelAndView.addObject("book",bookService.selectByPrimaryKey(bookId));
        }
        return modelAndView;
    }



    @RequestMapping(value = "/serch",method = RequestMethod.GET)
    public ModelAndView bookList(){
        ModelAndView modelAndView =  new ModelAndView("serch");
        return modelAndView;
    }

    /**
     * 书名模糊查询
     * @param bookName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/queryname",method = RequestMethod.GET)
    public ModelAndView bookList(@RequestParam("bookName")String bookName,
                                 @RequestParam(value="pageNum", defaultValue="1",required = false) int pageNum,
                                 @RequestParam(value="pageSize", defaultValue="10",required = false) int pageSize){
        ModelAndView modelAndView =  new ModelAndView("list");
        PageInfo pageInfo= bookService.queryBookByLikeName(bookName,pageNum,pageSize);
        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",bookService.queryBookByLikeName(bookName,pageNum,pageSize));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind","name");
        jsonObject.put("bookName",bookName);
        modelAndView.addObject("require",jsonObject);
        return modelAndView;
    }

    /**
     * 根据作者查询图书
     * @param author
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/queryauthor",method = RequestMethod.GET)
    public ModelAndView queryAuthor(@RequestParam("author")String author,
                                 @RequestParam(value="pageNum", defaultValue="1",required = false) int pageNum,
                                 @RequestParam(value="pageSize", defaultValue="10",required = false) int pageSize){
        ModelAndView modelAndView =  new ModelAndView("list");
        PageInfo pageInfo= bookService.queryBookByAuthor(author,pageNum,pageSize);
        modelAndView.addObject("pageInfo",pageInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind","author");
        jsonObject.put("author",author);
        modelAndView.addObject("require",jsonObject);
        return modelAndView;
    }

    /**
     * 按出版社查询
     * @param publisher
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/querypublisher",method = RequestMethod.GET)
    public ModelAndView queryPublisher(@RequestParam("publisher")String publisher,
                                 @RequestParam(value="pageNum", defaultValue="1",required = false) int pageNum,
                                 @RequestParam(value="pageSize", defaultValue="10",required = false) int pageSize){
        ModelAndView modelAndView =  new ModelAndView("list");
        PageInfo pageInfo= bookService.queryBookByPress(publisher,pageNum,pageSize);
        modelAndView.addObject("pageInfo",pageInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind","publisher");
        jsonObject.put("publisher",publisher);
        modelAndView.addObject("require",jsonObject);
        return modelAndView;
    }

    /**
     * 按分类查询
     * @param classify
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/queryclassify",method = RequestMethod.GET)
    public ModelAndView queryClassify(@RequestParam("classify")String classify,
                                       @RequestParam(value="pageNum", defaultValue="1",required = false) int pageNum,
                                       @RequestParam(value="pageSize", defaultValue="10",required = false) int pageSize){
        ModelAndView modelAndView =  new ModelAndView("list");
        PageInfo pageInfo= bookService.queryBookByClassifyID(classify,pageNum,pageSize);
        modelAndView.addObject("pageInfo",pageInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind","classify");
        jsonObject.put("classify",classify);
        modelAndView.addObject("require",jsonObject);
        return modelAndView;
    }


    /**
     * 多条件组合查询
     * @param bookName
     * @param author
     * @param ISBN
     * @param publisher
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/querycombine",method = RequestMethod.GET)
    public ModelAndView queryClassify(@RequestParam("bookName")String bookName,
                                      @RequestParam("author")String author,
                                      @RequestParam("ISBN")String ISBN,
                                      @RequestParam("publisher")String publisher,
                                      @RequestParam(value="pageNum", defaultValue="1",required = false) int pageNum,
                                      @RequestParam(value="pageSize", defaultValue="10",required = false) int pageSize){
        ModelAndView modelAndView =  new ModelAndView("list");
        PageInfo pageInfo= bookService.queryBookByCombine(bookName,author,ISBN,publisher,pageNum,pageSize);
        modelAndView.addObject("pageInfo",pageInfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind","combine");
        jsonObject.put("bookName",bookName);
        jsonObject.put("author",author);
        jsonObject.put("ISBN",ISBN);
        jsonObject.put("publisher",publisher);
        modelAndView.addObject("require",jsonObject);
        return modelAndView;
    }



}
