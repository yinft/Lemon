package com.lemon.domain.vo;


import lombok.Data;

import java.util.List;


/**
 * @Author: yinft
 * @Date: 2019/1/18 16:17
 * @Version 1.0
 */
@Data
public class MenuVo {

    private String name;

    private String path;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo meta;

    private List<MenuVo> children;

}
