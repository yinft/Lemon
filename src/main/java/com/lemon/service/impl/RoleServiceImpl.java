package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.RoleDao;
import com.lemon.domain.dto.RoleDto;
import com.lemon.domain.entity.Role;
import com.lemon.service.RoleService;
import com.lemon.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.management.relation.RoleStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yinft
 * @Date: 2019/2/18 22:04
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {


    @Autowired
    private RoleDao roleDao;


    @Override
    public List getRoleTree() {
        List<Role> roleList = roleDao.selectList(new QueryWrapper<>());

        List<Map<String, Object>> list = new ArrayList<>();
        for (Role role : roleList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id",role.getId());
            map.put("label",role.getName());
            list.add(map);
        }
        return list;
    }

    @Override
    public IPage<Role> getRolePage(Page<Role> page, String name) {
        IPage iPage=roleDao.selectPage(page,new QueryWrapper<Role>().like(!ObjectUtils.isEmpty(name), "name", name));
        return iPage;
    }

    @Override
    public void insert(Role role) {
        if(roleDao.selectOne(new QueryWrapper<Role>().eq("name",role.getName()))!=null ){
            throw new BaseException(110,"角色名重复");
        }
        roleDao.insert(role);
    }
}
