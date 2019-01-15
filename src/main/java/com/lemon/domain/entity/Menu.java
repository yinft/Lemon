package com.lemon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: yinft
 * @Date: 2019/1/14 16:10
 * @Version 1.0
 */
@Setter
@Getter
@TableName("menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Date createTime;

    /**
     * 侧边菜单名
     */
    private String name;

    /**
     * 组件url
     */
    private String component;

    /**
     * 父级菜单id
     */
    private Long pid;

    /**
     * 菜单排序
     */
    private Long sort;


    /**
     * 图标
     */
    private String icon;

    /**
     * 访问路径
     */
    private String path;



}
