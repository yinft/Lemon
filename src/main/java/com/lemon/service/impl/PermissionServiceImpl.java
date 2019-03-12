package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.PermissionDao;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.dto.PermissionDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import com.lemon.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @Author: yinft
 * @Date: 2019/1/21 14:17
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {


    @Autowired
    private PermissionDao permissionDao;


    @Override
    public Set<Permission> getPermissionsByUserId(long id) {
        Set<Permission> permissions = permissionDao.getByUserId(id);
        return permissions;
    }

    @Override
    public List<Permission> findByPid(long pid) {
        List<Permission> list = permissionDao.selectList(new QueryWrapper<Permission>().eq("pid", pid));
        return list;
    }

    @Override
    public List getPermissionTree(List<Permission> permissions) {
        List<Map<String, Object>> list = new LinkedList<>();
        permissions.forEach(menu -> {
                    if (menu != null) {
                        List<Permission> menuList = permissionDao.selectList(new QueryWrapper<Permission>().eq("pid", menu.getId()));
                        Map<String, Object> map = new HashMap<>();
                        map.put("id", menu.getId());
                        map.put("label", menu.getName());
                        if (menuList != null && menuList.size() != 0) {
                            map.put("children", getPermissionTree(menuList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }

    @Override
    public List<PermissionDto> getPermissionsByname(String name) {

        List<Permission> permissionList = permissionDao.selectList(new QueryWrapper<Permission>().like(!ObjectUtils.isEmpty(name), "name", name));
        List<PermissionDto> permissionDtoList = new ArrayList<>();
        for (Permission permission : permissionList) {
            PermissionDto permissionDto = new PermissionDto();
            BeanUtils.copyProperties(permission, permissionDto);
            permissionDtoList.add(permissionDto);
        }
        return permissionDtoList;
    }

    @Override
    public Map buildTree(List<PermissionDto> permissionDTOS) {
        List<PermissionDto> trees = new ArrayList<PermissionDto>();

        for (PermissionDto permissionDTO : permissionDTOS) {

            if ("0".equals(permissionDTO.getPid().toString())) {
                trees.add(permissionDTO);
            }

            for (PermissionDto it : permissionDTOS) {
                if (it.getPid().equals(permissionDTO.getId())) {
                    if (permissionDTO.getChildren() == null) {
                        permissionDTO.setChildren(new ArrayList<PermissionDto>());
                    }
                    permissionDTO.getChildren().add(it);
                }
            }
        }

        Integer totalElements = permissionDTOS != null ? permissionDTOS.size() : 0;
        Map map = new HashMap();
        map.put("content", trees.size() == 0 ? permissionDTOS : trees);
        map.put("totalElements", totalElements);
        return map;
    }
}
