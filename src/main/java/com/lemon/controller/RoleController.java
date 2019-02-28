package com.lemon.controller;

import com.lemon.domain.vo.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yinft
 * @Date: 2019/2/21 10:40
 * @Version 1.0
 */
@Slf4j
@Api(description = "角色管理")
@RestController
@RequestMapping("api")
public class RoleController {

    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_DELETE')")
    @GetMapping(value = "/test")
    public ResultMap<Long> deleteMenus(Long id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://Server-Provider/user/{id}")
                .build().expand(params).encode().toUri();
        log.info("url是:"+uri.toString());
        return ResultMap.success(id);
    }
}
