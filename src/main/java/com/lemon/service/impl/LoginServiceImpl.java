package com.lemon.service.impl;


import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.config.auth.JwtUser;
import com.lemon.service.UserService;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.entity.User;
import com.lemon.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yinft
 * @Date: 2019/1/10 22:06
 * @Version 1.0
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    public JwtAuthenticationDto login(LoginDto loginDto) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());

        if(!userDetails.getPassword().equals(com.lemon.utils.EncryptUtils.encryptPassword(loginDto.getPassword()))){
            throw new AccountExpiredException("密码错误");
        }

        if(!userDetails.isEnabled()){
            throw new AccountExpiredException("账号已停用，请联系管理员");
        }

        // 生成令牌
        final String token = jwtTokenUtil.generateToken(userDetails);

        // 返回 token
        return new JwtAuthenticationDto(token);
    }

    @Override
    public JwtUser getUserInfo(HttpServletRequest request) {
        JwtUser jwtUser = (JwtUser)userDetailsService.loadUserByUsername(jwtTokenUtil.getUserName(request));
        return jwtUser;
    }
}
