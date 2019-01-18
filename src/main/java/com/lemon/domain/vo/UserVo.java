package com.lemon.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/16 22:08
 * @Version 1.0
 */
@Getter
@Setter
public class UserVo {


    private Integer id;


    private String avatar;


    private Date createTime;


    private Date updateTime;


    private String phone;


    private String email;


    private String password;


    private String username;


    private Boolean enabled;

    private Set<RoleVo> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
