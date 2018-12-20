package com.lemon.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;

/**
 * @Author: yinft
 * @Date: 2018/12/20 22:00
 * @Version 1.0
 */
public interface UserService extends IService {

    /**
     * 登陆
     */
    JwtAuthenticationDto login(LoginDto loginDto);

}
