package com.lemon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.MenuDao;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Role;
import com.lemon.domain.vo.MenuVo;
import com.lemon.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @Author: yinft
 * @Date: 2019/2/18 15:08
 * @Version 1.0
 */
@Service
public class MenuServiceImpl  extends ServiceImpl<MenuDao,Menu> implements MenuService {
    @Override
    public Map buildTree(List<MenuDto> menuDTOS) {
        return null;
    }

    @Override
    public List<MenuDto> findByRoles(Set<Role> roles) {
        return null;
    }

    @Override
    public List<MenuVo> buildMenus(List<MenuDto> byRoles) {
        return null;
    }
}
