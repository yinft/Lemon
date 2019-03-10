package com.lemon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.domain.dto.UserAddDTO;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: yinft
 * @Date: 2019/1/10 22:27
 * @Version 1.0
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    IPage<UserVo> page(Page<UserVo> page, @Param("u") UserDto userDto);

    Long insertAndGetId(UserAddDTO userAddDTO);
    void updateUser(UserAddDTO userAddDTO);
}
