package com.lemon.domain.dto;

import lombok.Data;

/**
 * 分页请求参数
 *
 * @author earthchen
 * @date 2018/9/6
 **/
@Data
public class PageParamDTO
{

    private Integer size = 10;

    private Integer current = 0;


}
