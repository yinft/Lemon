package com.lemon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.config.auth.JwtUser;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
import com.lemon.utils.pageplug.MyPageable;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yinft
 * @Date: 2018/12/20 22:00
 * @Version 1.0
 */
public interface LoginService extends IService<User> {

    /**
     * @param loginDto
     * 登陆
     */
    JwtAuthenticationDto login(LoginDto loginDto);



    JwtUser getUserInfo(HttpServletRequest request);

    User findByName(String username);




}
