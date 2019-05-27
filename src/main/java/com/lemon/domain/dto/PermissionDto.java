package com.lemon.domain.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @Author: yinft
 * @Date: 2019/3/12 16:29
 * @Version 1.0
 */
@Data
public class PermissionDto {
    private Long id;

    private String name;

    private Long pid;

    private String alias;

    private Date createTime;

    private List<PermissionDto> children;

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
