package com.lemon.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;


/**
 * @Author: yinft
 * @Date: 2019/2/28 21:15
 * @Version 1.0
 */

public interface UserService extends IService<User> {

    IPage<UserVo> getUserPage(PageParamDTO pageParamDTO, UserDto userDto);

}
