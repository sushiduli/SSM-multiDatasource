package com.cn.kg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.kg.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
