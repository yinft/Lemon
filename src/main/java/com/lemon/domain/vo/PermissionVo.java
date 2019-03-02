package com.lemon.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lemon.common.constant.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/18 16:47
 * @Version 1.0
 */
@Setter
@Getter
public class PermissionVo {


    private Integer id;


    private String alias;

    @JsonFormat(pattern = Constants.DEFAULT_DATE_PATTERN, timezone = "GMT+8")
    private Date createTime;


    private String name;


    private Integer pid;

    private Set<RoleVo> roles;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", alias='" + alias + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
