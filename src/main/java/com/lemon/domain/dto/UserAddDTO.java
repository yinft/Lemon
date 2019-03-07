package com.lemon.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    Long id;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 密码
     */
    @JsonIgnore
    private String avatar;

    /**
     * 账户状态
     */
    private Boolean enabled;

    /**
     * 角色id集合
     */
    private List<Long> roleIds;
}
