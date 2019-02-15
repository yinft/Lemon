package com.lemon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.config.auth.JwtUser;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: yinft
 * @Date: 2019/1/10 22:27
 * @Version 1.0
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    UserVo findByUsername(@Param("username") String username);


    UserVo findByEmail(@Param("email") String username);


}
