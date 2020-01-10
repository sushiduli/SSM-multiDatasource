package com.cn.kg.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.kg.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectByPage(Page page);
}
