package com.cn.kg.controller;

import com.cn.kg.entity.User;
import com.cn.kg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mvc-template
 * @description: TODO
 * @author: konggang
 * @create: 2019-11-02 03:13
 **/
@RestController
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("/a")
    @Cacheable(cacheNames = {"Live_Cache:"},key = "#id")
    public Object a(String id){




        User user = userService.getById(1);
        log.info(user.toString());
        return user;
    }
}
