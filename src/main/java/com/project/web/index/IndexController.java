package com.project.web.index;

import com.project.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        String content =  helloWorldService.getHelloWorldContent();
        modelAndView.addObject("content",content);
        modelAndView.setViewName("helloworld");
        return modelAndView;
    }


}
