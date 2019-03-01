package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.entity.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: yinft
 * @Date: 2019/2/18 10:46
 * @Version 1.0
 */

public interface RoleService extends IService<Role> {

    /**
     * role tree
     *
     * @return
     */
    @Cacheable(key = "'tree'")
    List getRoleTree();

}
