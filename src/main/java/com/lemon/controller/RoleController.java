package com.lemon.controller;

import com.lemon.domain.vo.ResultMap;
import com.lemon.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.Max;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private RoleService roleService;

    /**
     * 返回全部的角色，新增用户时下拉选择
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "全部角色", notes = "全部角色", consumes = "application/json")
    @GetMapping(value = "/roles/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT','ROLES_ALL','USER_ALL','USER_SELECT')")
    public ResultMap<List> getRoleTree(){
      List list=roleService.getRoleTree();
        return ResultMap.success(list);
    }
}
