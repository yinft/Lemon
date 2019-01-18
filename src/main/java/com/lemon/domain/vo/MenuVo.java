package com.lemon.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/18 16:17
 * @Version 1.0
 */
@Setter
@Getter
public class MenuVo {


    private Integer id;

    private Date createTime;


    private String name;


    private String component;


    private Long pid;


    private Long sort;



    private String icon;


    private String path;

    private Set<RoleVo> roles;

}
