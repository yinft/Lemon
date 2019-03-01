package com.lemon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.ResultMap;
import com.lemon.domain.vo.UserVo;
import com.lemon.service.LoginService;
import com.lemon.service.UserService;
import com.lemon.utils.pageplug.MyPageable;
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

    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表", consumes = "application/json")
    @GetMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_SELECT')")
    public ResultMap<IPage<UserVo>> getUsers(Page<UserVo> myPageable, @RequestBody UserDto userDto){
        IPage<UserVo> userVoIPage=userService.getUserPage(myPageable,userDto);
        return ResultMap.success(userVoIPage);

    }


    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "新增用户", notes = "新增用户", consumes = "application/json")
    @PostMapping(value = "/users")
    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody User resources){
      return null;
    }


}
