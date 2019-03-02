package com.lemon.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: yinft
 * @Date: 2019/2/28 20:45
 * @Version 1.0
 */
@Data
public class UserDto {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("账号状态")
    private Boolean enabled;

    @ApiModelProperty("根据创建时间排序，正序：asc，倒序：desc，不传或者传null则不排序")
    private String timeSort;

}
