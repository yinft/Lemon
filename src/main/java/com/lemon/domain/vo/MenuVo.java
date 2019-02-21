package com.lemon.domain.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @Author: yinft
 * @Date: 2019/1/18 16:17
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVo {


    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("")
    private String redirect;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("是否显示")
    private Boolean alwaysShow;

    @ApiModelProperty("元信息")
    private MenuMetaVo meta;

    @ApiModelProperty("子目录")
    private List<MenuVo> children;

}
