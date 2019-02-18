package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;

import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/21 11:49
 * @Version 1.0
 */

public interface PermissionService extends IService<Permission> {

    Set<Permission> getPermissionsByUserId(long id);

}
