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
 * @Date: 2019/1/14 16:09
 * @Version 1.0
 */
@Setter
@Getter
@TableName("permission")
public class Permission extends Model<Permission> {


    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 别名
     */
    private String alias;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 名称
     */
    private String name;

    /**
     * 父级id
     */
    private Integer pid;


}
