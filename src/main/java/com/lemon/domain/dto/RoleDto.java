package com.lemon.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/2/18 13:53
 * @Version 1.0
 */
@Data
public class RoleDto {

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("根据创建时间排序，正序：asc，倒序：desc，不传或者传null则不排序")
    private String timeSort;
}
