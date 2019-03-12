package com.lemon.controller;

import com.lemon.common.constant.Constants;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.dto.PermissionDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.vo.ResultMap;
import com.lemon.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @Autowired
    private PermissionService permissionService;
    /**
     * 返回全部的权限，新增角色时下拉选择
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "获取全部权限", notes = "获取全部权限", consumes = "application/json")
    @GetMapping(value = "/permissions/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT','ROLES_SELECT','ROLES_ALL')")
    public ResultMap getRoleTree(){
        List list=permissionService.getPermissionTree(permissionService.findByPid(0L));
        return ResultMap.success(list);
    }



    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "查询权限", notes = "查询权限", consumes = "application/json")
    @GetMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResultMap<Map> getPermissions(@RequestParam(required = false) String name){
        List<PermissionDto> menuDTOList= permissionService.getPermissionsByname(name);
        Map map= permissionService.buildTree(menuDTOList);
        return ResultMap.success(map);
    }

    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "新增权限", notes = "新增权限", consumes = "application/json")
    @PostMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResultMap create(@Validated @RequestBody Permission permission){
        permissionService.create(permission);
        return ResultMap.success();
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
