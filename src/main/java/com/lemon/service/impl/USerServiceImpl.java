package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
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
public class USerServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

@Autowired
private UserDao userDao;


    @Override
    public IPage<UserVo> getUserPage(Page<UserVo> myPageable,UserDto userDto) {
//        QueryWrapper<User> queryWrapper =new QueryWrapper();
//        IPage<User> page=userDao.selectList(myPageable,queryWrapper.eq(
//                userDto.getUsername()!=null,"username",userDto.getUsername()));
//
//        return page;
        return null;
    }
}
