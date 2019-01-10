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
 * @Date: 2019/1/10 20:34
 * @Version 1.0
 */
@Setter
@Getter
@TableName("user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;



    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 创建时间
     */
    private Date utime;


    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;

    /**
     * 账户状态
     */
    private Boolean enabled;
}
