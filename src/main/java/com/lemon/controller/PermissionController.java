package com.lemon.controller;

import com.lemon.common.constant.Constants;
import com.lemon.domain.vo.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: yinft
 * @Date: 2019/2/21 10:41
 * @Version 1.0
 */
@Slf4j
@Api(description = "权限资源管理")
@RestController
@RequestMapping("api")
public class PermissionController {

    /**
     * 返回全部的权限，新增角色时下拉选择
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "获取全部权限", notes = "获取全部权限", consumes = "application/json")
    @GetMapping(value = "/permissions/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT','ROLES_SELECT','ROLES_ALL')")
    public ResultMap getRoleTree(){
        return null;
    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "查询权限", notes = "查询权限", consumes = "application/json")
    @GetMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResultMap getPermissions(@RequestParam(required = false) String name){

        return null;
    }

    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "新增权限", notes = "新增权限", consumes = "application/json")
    @PostMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResultMap create(){

        return null;
    }

    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "修改权限", notes = "修改权限", consumes = "application/json")
    @PutMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_EDIT')")
    public ResultMap update(){

        return null;
    }

    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "删除权限", notes = "删除权限", consumes = "application/json")
    @DeleteMapping(value = "/permissions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_DELETE')")
    public ResultMap delete(@PathVariable Long id){

        return null;
    }


}
