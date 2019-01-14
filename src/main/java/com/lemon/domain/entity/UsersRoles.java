package com.lemon.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: yinft
 * @Date: 2019/1/14 16:13
 * @Version 1.0
 */
@Setter
@Getter
@TableName("users_roles")
public class UsersRoles extends Model<UsersRoles> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;



    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;


    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;

}
