package com.lemon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Role;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author: yinft
 * @Date: 2019/1/14 17:10
 * @Version 1.0
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {
    /**
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Menu> findByRolesOrderBySort(Set<Role> roleSet);

    LinkedHashSet<Menu> getByUserId(@Param("id") Long id);

    void save(MenuDto menuDto);

}
