package com.lemon.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.JwtAuthenticationDto;
import com.lemon.domain.dto.LoginDto;
import com.lemon.domain.entity.SysUser;

/**
 * @Author: yinft
 * @Date: 2018/12/20 22:00
 * @Version 1.0
 */
public interface UserService extends IService<SysUser> {

    /**
     * 登陆
     */
    JwtAuthenticationDto login(LoginDto loginDto);

}
