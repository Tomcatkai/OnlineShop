package com.onlineshop.service;

import com.onlineshop.dao.AdministratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员业务
 *
 * @author kaizhang
 * @create 2018-05-12 2:58
 **/
@Service
public class AdminService {
    @Autowired
    AdministratorDao administratorDao;

    public boolean adminLoin(String adminName,String adminPass){
        if(administratorDao.selectAdminByPassAndName(adminName,adminPass)>0){
            return true;
        }
        return false;
    }
}
