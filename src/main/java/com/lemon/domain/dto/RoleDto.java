package com.lemon.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
}
