package com.lemon.service;

import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Role;
import com.lemon.domain.vo.MenuVo;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/2/18 10:46
 * @Version 1.0
 */
@CacheConfig(cacheNames = "menu")
public interface MenuService {


    /**
     * build Tree
     * @param menuDTOS
     * @return
     */
    Map buildTree(List<MenuDto> menuDTOS);

    /**
     * findByRoles
     * @param roles
     * @return
     */
    List<MenuDto> findByRoles(Set<Role> roles);



    /**
     * buildMenus
     * @param byRoles
     * @return
     */
    List<MenuVo> buildMenus(List<MenuDto> byRoles);
}
