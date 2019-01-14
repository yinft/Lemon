package com.lemon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: yinft
 * @Date: 2019/1/14 10:40
 * @Version 1.0
 */

@Setter
@Getter
@TableName("role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;



    /**
     * 角色名称
     */
    private String name;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 标识
     */
    private String remark;

}
