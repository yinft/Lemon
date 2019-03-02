package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
import com.lemon.service.MenuService;
import com.lemon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yinft
 * @Date: 2019/2/28 21:15
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

@Autowired
private UserDao userDao;

UserService userService;

    @Override
    public IPage<UserVo> getUserPage(PageParamDTO pageParamDTO, UserDto userDto) {
        Page<UserVo> page =new Page<>(pageParamDTO.getPage(),pageParamDTO.getSize());

        IPage<UserVo> iPage= userDao.page(page,userDto);
        return iPage;
    }
}
