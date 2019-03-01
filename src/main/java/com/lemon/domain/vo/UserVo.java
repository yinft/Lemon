package com.lemon.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lemon.domain.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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


    private Long id;


    private String avatar;


    private Date createTime;


    private Date updateTime;


    private String email;

    @JsonIgnore
    private String password;


    private String username;


    private Boolean enabled;


}
