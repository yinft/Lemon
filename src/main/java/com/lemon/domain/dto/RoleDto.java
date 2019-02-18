package com.lemon.domain.dto;

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
    private Long id;

    private String name;

    private String remark;

    private Timestamp createTime;
}
