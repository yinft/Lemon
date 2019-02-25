package com.lemon.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.untils.ValidationUtil;
import com.lemon.config.auth.JwtUser;
import com.lemon.enums.ResultEnum;
import com.lemon.service.UserService;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.entity.User;
import com.lemon.utils.EncryptUtils;
import com.lemon.utils.JwtTokenUtil;
import com.lemon.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private UserDao userDao;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    public JwtAuthenticationDto login(LoginDto loginDto) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());

        if(!userDetails.getPassword().equals(EncryptUtils.encryptPassword(loginDto.getPassword()))){
            throw new BaseException(ResultEnum.PASSWORD_DONT_EXISTS.getCode(),ResultEnum.PASSWORD_DONT_EXISTS.getMessage());
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

    @Override
    public User findByName(String username) {
        User user = null;
        if (ValidationUtil.isEmail(username)) {
            user = userDao.selectOne (new QueryWrapper<User>().eq("email", username));
        } else {
            user = userDao.selectOne(new QueryWrapper<User>().eq("username", username));
        }

        if (user == null) {
            throw new BaseException(ResultEnum.USER_DONT_EXISTS.getCode(),ResultEnum.USER_DONT_EXISTS.getMessage());
        } else {

            return user;
        }
    }
}
