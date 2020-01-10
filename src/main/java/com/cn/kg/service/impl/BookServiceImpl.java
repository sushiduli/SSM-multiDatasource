package com.cn.kg.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.kg.dao.BookMapper;
import com.cn.kg.entity.Book;
import com.cn.kg.service.BookService;

import org.springframework.stereotype.Service;

/**
 * @program: demo-plus
 * @description: TODO
 * @author: konggang
 * @create: 2019-10-18 23:43
 **/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
