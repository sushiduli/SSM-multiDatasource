package com.cn.kg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @program: demo-plus
 * @description: TODO
 * @author: konggang
 * @create: 2019-10-18 23:27
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private Integer age;
    private String detail;
}
