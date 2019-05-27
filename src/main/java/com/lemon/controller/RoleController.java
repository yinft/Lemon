package com.lemon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.common.constant.Constants;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.RoleDto;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.Role;
import com.lemon.domain.vo.ResultMap;
import com.lemon.domain.vo.UserVo;
import com.lemon.enums.ResultEnum;
import com.lemon.service.RoleService;
import com.lemon.utils.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "全部角色", notes = "全部角色", consumes = "application/json")
    @GetMapping(value = "/roles/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT','ROLES_ALL','USER_ALL','USER_SELECT')")
    public ResultMap<List> getRoleTree(){
      List list=roleService.getRoleTree();
        return ResultMap.success(list);
    }



    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "查询角色", notes = "查询角色", consumes = "application/json")
    @GetMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_SELECT')")
    public ResultMap<IPage<Role>> getRoles(PageParamDTO pageParamDTO, RoleDto roleDto){
        IPage<Role> rolePage=roleService.getRolePage(pageParamDTO,roleDto);
        return ResultMap.success(rolePage);
    }



    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "新增角色", notes = "新增角色", consumes = "application/json")
    @PostMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_CREATE')")
    public ResultMap create(@Validated @RequestBody Role role){
        roleService.insert(role);
        return ResultMap.success();
    }



    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "修改角色", notes = "修改角色", consumes = "application/json")
    @PutMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_EDIT')")
    public ResultMap<List> update(@Validated @RequestBody Role role){
        if (role.getId() == null) {
            throw new BaseException(ResultEnum.NULL_ID.getCode(),ResultEnum.NULL_ID.getMessage());
        }
        roleService.update(role);
        return ResultMap.success();
    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "修改角色权限关联", notes = "修改角色权限", consumes = "application/json")
    @PutMapping(value = "/roles/permission")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_EDIT')")
    public ResultMap<List> updatePermission(@Validated @RequestBody Role role){

        roleService.update(role);
        return ResultMap.success();
    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "修改角色菜单关联", notes = "修改角色菜单", consumes = "application/json")
    @PutMapping(value = "/roles/menus")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_EDIT')")
    public ResultMap<List> updateMenu(@Validated @RequestBody Role role){

        roleService.update(role);
        return ResultMap.success();
    }




    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "删除角色", notes = "删除角色", consumes = "application/json")
    @DeleteMapping(value = "/roles/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ROLES_ALL','ROLES_DELETE')")
    public ResultMap<List> delete(@PathVariable Long id){
        roleService.delete(id);
        return ResultMap.success();
    }
}
