package com.project.service;

import com.project.dao.HelloWorldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Autowired
    HelloWorldDao helloWorldDao;

    public String getHelloWorldContent(){
       return helloWorldDao.HelloWorld();
    }
}
