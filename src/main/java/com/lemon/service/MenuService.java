package com.lemon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import com.lemon.domain.vo.MenuVo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/2/18 10:46
 * @Version 1.0
 */
@CacheConfig(cacheNames = "menu")
public interface MenuService extends IService<Menu> {


    /**
     * build Tree
     * @param menuDTOS
     * @return
     */
    Map buildTree(List<MenuDto> menuDTOS);


    /**
     * getMenusByUserId
     * @param id
     * @return
     */
    List<MenuDto> getMenusByUserId(Long id);

    /**
     * buildMenus
     * @param byRoles
     * @return
     */
    List<MenuVo> buildMenus(List<MenuDto> byRoles);


    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Menu> getByPid(long pid);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    List getMenuTree(List<Menu> menus);

}
