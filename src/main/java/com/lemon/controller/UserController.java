package com.lemon.controller;

import com.lemon.Service.UserService;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.vo.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: yinft
 * @Date: 2018/12/18 22:03
 * @Version 1.0
 */
@Slf4j
@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登陆", notes = "登陆", consumes = "application/json")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap<JwtAuthenticationDto> login(@RequestBody @Valid ResultMap<LoginDto> requestObject) {
        LoginDto loginDto = requestObject.getData();
        JwtAuthenticationDto token = userService.login(loginDto);
        return ResultMap.success(token);
    }


}
