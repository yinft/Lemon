package com.lemon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.common.constant.Constants;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.ResultMap;
import com.lemon.domain.vo.UserVo;
import com.lemon.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yinft
 * @Date: 2019/2/21 10:39
 * @Version 1.0
 */
@Slf4j
@Api(description = "用户管理")
@RestController
@RequestMapping("api")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表", consumes = "application/json")
    @GetMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT')")
    public ResultMap<IPage<UserVo>> getUsers(PageParamDTO pageParamDTO, UserDto userDto){


        IPage<UserVo> userVoPage=userService.getUserPage(pageParamDTO,userDto);

        return ResultMap.success(userVoPage);

    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "新增用户", notes = "新增用户", consumes = "application/json")
    @PostMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody User resources){
      return null;
    }




    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "删除用户", notes = "删除用户", consumes = "application/json")
    @DeleteMapping(value = "/users/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_DELETE')")
    public ResultMap delete(@PathVariable Long id){
        userService.delete(id);
        return ResultMap.success();
    }

}
