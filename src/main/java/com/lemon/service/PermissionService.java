package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.dto.PermissionDto;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/21 11:49
 * @Version 1.0
 */

public interface PermissionService extends IService<Permission> {

    Set<Permission> getPermissionsByUserId(long id);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Permission> findByPid(long pid);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    List getPermissionTree(List<Permission> permissions);


    @Cacheable(key = "'queryAll:'+#p0")
    List<PermissionDto> getPermissionsByname(String name);

    /**
     * build Tree
     * @param permissionDTOS
     * @return
     */
    Map buildTree(List<PermissionDto> permissionDTOS);

    /**
     * create
     * @param permission
     * @return
     */
    @CacheEvict(allEntries = true)
    void create(Permission permission);

}
