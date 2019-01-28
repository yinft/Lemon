package com.lemon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/14 17:10
 * @Version 1.0
 */
public interface PermissionDao extends BaseMapper<Permission> {

  Set<Permission> seletPermissionsByRoles(@Param("id") Long id);
}
