package com.lemon.controller;

import com.lemon.config.auth.JwtUser;
import com.lemon.service.UserService;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.vo.ResultMap;
import com.lemon.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: yinft
 * @Date: 2018/12/18 22:03
 * @Version 1.0
 */
@Slf4j
@Api(description = "用户管理")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "登陆", notes = "登陆", consumes = "application/json")
    @RequestMapping(value = "${jwt.auth.path}", method = RequestMethod.POST)
    public ResultMap<JwtAuthenticationDto> login(@RequestBody @Valid LoginDto loginDto) {
        JwtAuthenticationDto token = userService.login(loginDto);
        return ResultMap.success(token);
    }


    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", consumes = "application/json")
    @GetMapping(value = "${jwt.auth.account}")
    public ResultMap<JwtUser> getUserInfo(HttpServletRequest request) {

        JwtUser jwtUser = userService.getUserInfo(request);

        return ResultMap.success(jwtUser);
    }

}
