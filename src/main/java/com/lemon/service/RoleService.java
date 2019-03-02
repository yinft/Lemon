package com.lemon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.RoleDto;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.Role;
import com.lemon.domain.vo.UserVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: yinft
 * @Date: 2019/2/18 10:46
 * @Version 1.0
 */
@CacheConfig(cacheNames = "role")
public interface RoleService extends IService<Role> {

    /**
     * role tree
     *
     * @return
     */
    @Cacheable(key = "'tree'")
    List getRoleTree();


    /**
     * 分页
     */

    IPage<Role> getRolePage(PageParamDTO pageParamDTO, RoleDto roleDto);

/**
* 新增角色
*/
void insert(Role role);
}
