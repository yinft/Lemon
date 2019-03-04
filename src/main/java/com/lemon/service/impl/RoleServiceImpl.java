package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.RoleDao;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.RoleDto;
import com.lemon.domain.entity.Role;
import com.lemon.enums.ResultEnum;
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
            map.put("id", role.getId());
            map.put("label", role.getName());
            list.add(map);
        }
        return list;
    }

    @Override
    public IPage<Role> getRolePage(PageParamDTO pageParamDTO, RoleDto roleDto) {
        Page<Role> myPage = new Page<>(pageParamDTO.getCurrent(), pageParamDTO.getSize());
        IPage iPage = roleDao.selectPage(myPage, new QueryWrapper<Role>()
                .like(!ObjectUtils.isEmpty(roleDto.getName()), "name", roleDto.getName())
                .orderByAsc(!ObjectUtils.isEmpty(roleDto.getTimeSort()) && roleDto.getTimeSort().equals("asc"), "createTime")
                .orderByDesc(!ObjectUtils.isEmpty(roleDto.getTimeSort()) && roleDto.getTimeSort().equals("desc"), "createTime")
        );
        return iPage;
    }

    @Override
    public void insert(Role role) {
        if (roleDao.selectOne(new QueryWrapper<Role>().eq("name", role.getName())) != null) {
            throw new BaseException(ResultEnum.REPEAD_ROLENAME.getCode(), ResultEnum.REPEAD_ROLENAME.getMessage());
        }
        roleDao.insert(role);
    }

    @Override
    public void update(Role role) {
        /**
         * 根据实际需求,超级管理员无法修改
         */
        if (role.getId().equals(1L)) {
            throw new BaseException(ResultEnum.CAN_NOT_UPDATEROLE.getCode(), ResultEnum.CAN_NOT_UPDATEROLE.getMessage());
        }

        if (roleDao.selectById(role.getId()) == null) {
            throw new BaseException(ResultEnum.RELE_NOT_EXIST.getCode(), ResultEnum.RELE_NOT_EXIST.getMessage());
        }

        roleDao.updateById(role);

    }

    @Override
    public void delete(Long id) {
        /**
         * 根据实际需求,超级管理员无法删除
         */
        if (id.equals(1L)) {
            throw new BaseException(ResultEnum.CAN_NOT_DELETEROLE.getCode(), ResultEnum.CAN_NOT_DELETEROLE.getMessage());
        }
        roleDao.deleteById(id);
    }
}
