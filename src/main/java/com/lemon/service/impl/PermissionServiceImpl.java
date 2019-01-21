package com.lemon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.PermissionDao;
import com.lemon.dao.UserDao;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import com.lemon.domain.entity.User;
import com.lemon.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/21 14:17
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl  extends ServiceImpl<PermissionDao,Permission> implements PermissionService {


    @Override
    public Set<Permission> findByRoles(Set<Role> roleSet) {
        return null;
    }
}
