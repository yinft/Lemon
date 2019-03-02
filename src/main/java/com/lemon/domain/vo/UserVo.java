package com.lemon.domain.vo;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lemon.common.constant.Constants;
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

    @JsonFormat(pattern = Constants.DEFAULT_DATE_PATTERN, timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = Constants.DEFAULT_DATE_PATTERN, timezone = "GMT+8")
    private Date updateTime;


    private String email;



    private String username;


    private Boolean enabled;


}
