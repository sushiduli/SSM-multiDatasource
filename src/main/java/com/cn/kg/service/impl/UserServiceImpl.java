package com.cn.kg.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.kg.config.datasource.annotation.Master;
import com.cn.kg.dao.UserMapper;
import com.cn.kg.entity.User;
import com.cn.kg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @program: demo-plus
 * @description: TODO
 * @author: konggang
 * @create: 2019-10-18 23:37
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Master
    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }

    public List<User> selectByPage(Page page){
        return userMapper.selectByPage(page);
    }
}
