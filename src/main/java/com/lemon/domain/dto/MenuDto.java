package com.lemon.domain.dto;

import com.lemon.domain.entity.Menu;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/2/18 13:51
 * @Version 1.0
 */
@Data
public class MenuDto {
    private Long id;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private Long pid;

    private String icon;

    private Boolean iFrame;

    private Set<RoleDto> roles;

    private List<MenuDto> children;

    private Timestamp createTime;

    public MenuDto() {

    }


    public MenuDto(Menu menu) {

        BeanUtils.copyProperties(menu, this);
    }

}
