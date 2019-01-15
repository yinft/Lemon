package com.lemon.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.service.UserService;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: yinft
 * @Date: 2019/1/10 22:06
 * @Version 1.0
 */
public class LoginServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Autowired
//    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    public JwtAuthenticationDto login(LoginDto loginDto) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
        return null;
    }
}
