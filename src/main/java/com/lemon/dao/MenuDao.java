package com.lemon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Role;

import java.util.Set;


/**
 * @Author: yinft
 * @Date: 2019/1/14 17:10
 * @Version 1.0
 */

public interface MenuDao extends BaseMapper<Menu> {
    /**
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Menu> findByRolesOrderBySort(Set<Role> roleSet);

}
