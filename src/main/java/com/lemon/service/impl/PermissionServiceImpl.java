package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.PermissionDao;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import com.lemon.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/21 14:17
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {


    @Override
    public Set<Permission> findByRoles(Set<Role> roleSet) {
        return null;
    }
}
