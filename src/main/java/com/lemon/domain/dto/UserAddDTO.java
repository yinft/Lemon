package com.lemon.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: yinft
 * @Date: 2019/3/6 17:05
 * @Version 1.0
 */
@Data
public class UserAddDTO {
    private Long id;


    /**
     * 创建时间
     */

    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;


    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账户状态
     */
    private Boolean enabled;

    /**
     * 角色id集合
     */
    private List roleIds;
}
