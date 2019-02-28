package com.lemon.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.MenuDao;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Role;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.MenuMetaVo;
import com.lemon.domain.vo.MenuVo;
import com.lemon.enums.ResultEnum;
import com.lemon.service.MenuService;
import com.lemon.service.RoleService;
import com.lemon.utils.exception.BaseException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Author: yinft
 * @Date: 2019/2/18 15:08
 * @Version 1.0
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Autowired
    private MenuDao menuDao;


    @Override
    public Map buildTree(List<MenuDto> menuDTOS) {
        List<MenuDto> trees = new ArrayList<MenuDto>();

        for (MenuDto menuDTO : menuDTOS) {

            if ("0".equals(menuDTO.getPid().toString())) {
                trees.add(menuDTO);
            }

            for (MenuDto it : menuDTOS) {
                if (it.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<MenuDto>());
                    }
                    menuDTO.getChildren().add(it);
                }
            }
        }

        Integer totalElements = menuDTOS != null ? menuDTOS.size() : 0;
        Map map = new HashMap();
        map.put("content", trees.size() == 0 ? menuDTOS : trees);
        map.put("totalElements", totalElements);
        return map;
    }

//    @Override
//    public List<MenuDto> findByRoles(Set<Role> roles) {
//
//        Set<Menu> menus = new LinkedHashSet<>();
//        for (Role role : roles) {
//            Set<Role> roleSet = new HashSet<>();
//            roleSet.add(role);
//           long id= roleService.getOne(new QueryWrapper<Role>().eq("name", role)).getId();
//            menus.addAll(menuDao.findByRolesOrderBySort(id));
//        }
//        return menus.stream().map(menuDao::toDto).collect(Collectors.toList());
//    }

    @Override
    public List<MenuDto> getMenusByUserId(Long id) {

        Set<Menu> menuSet = new LinkedHashSet<>(menuDao.getByUserId(id));

        List<MenuDto> menuDtoList = new LinkedList<>();

        for (Menu menu : menuSet) {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            menuDtoList.add(menuDto);
        }
//        List<MenuDto> result = new ArrayList<MenuDto>(menuSet);


//        menuSet.forEach(menu -> BeanUtils.copyProperties(menu, menuDto));
//        List<MenuDto> menuDtoList= menuSet.stream().map(menu -> new MenuDto(menu)).collect(Collectors.toList());
        return menuDtoList;
    }

    @Override
    public List<MenuVo> buildMenus(List<MenuDto> menuDTOS) {

        List<MenuVo> list = new LinkedList<>();
        menuDTOS.forEach(menuDTO -> {
                    if (menuDTO != null) {
                        List<MenuDto> menuDTOList = menuDTO.getChildren();
                        MenuVo menuVo = new MenuVo();
                        menuVo.setName(menuDTO.getName());
                        menuVo.setPath(menuDTO.getPath());

                        // 如果不是外链
                        if (!menuDTO.getIFrame()) {
                            if (menuDTO.getPid().equals(0L)) {
                                //一级目录需要加斜杠，不然访问不了
                                menuVo.setPath("/" + menuDTO.getPath());
                                menuVo.setComponent(StrUtil.isEmpty(menuDTO.getComponent()) ? "Layout" : menuDTO.getComponent());
                            } else if (!StrUtil.isEmpty(menuDTO.getComponent())) {
                                menuVo.setComponent(menuDTO.getComponent());
                            }
                        }
                        menuVo.setMeta(new MenuMetaVo(menuDTO.getName(), menuDTO.getIcon()));
                        if (menuDTOList != null && menuDTOList.size() != 0) {
                            menuVo.setAlwaysShow(true);
                            menuVo.setRedirect("noredirect");
                            menuVo.setChildren(buildMenus(menuDTOList));
                            // 处理是一级菜单并且没有子菜单的情况
                        } else if (menuDTO.getPid().equals(0L)) {
                            MenuVo menuVo1 = new MenuVo();
                            menuVo1.setMeta(menuVo.getMeta());
                            // 非外链
                            if (!menuDTO.getIFrame()) {
                                menuVo1.setPath("index");
                                menuVo1.setName(menuVo.getName());
                                menuVo1.setComponent(menuVo.getComponent());
                            } else {
                                menuVo1.setPath(menuDTO.getPath());
                            }
                            menuVo.setName(null);
                            menuVo.setMeta(null);
                            menuVo.setComponent("Layout");
                            List<MenuVo> list1 = new ArrayList<MenuVo>();
                            list1.add(menuVo1);
                            menuVo.setChildren(list1);
                        }
                        list.add(menuVo);
                    }
                }
        );
        return list;
    }

    @Override
    public List<Menu> getByPid(long pid) {
        List<Menu> list = menuDao.selectList(new QueryWrapper<Menu>().eq("pid", pid));
        return list;
    }

    @Override
    public List getMenuTree(List<Menu> menus) {
        List<Map<String, Object>> list = new LinkedList<>();
        menus.forEach(menu -> {
                    if (menu != null) {
                        List<Menu> menuList = menuDao.selectList(new QueryWrapper<Menu>().eq("pid", menu.getId()));
                        Map<String, Object> map = new HashMap<>();
                        map.put("id", menu.getId());
                        map.put("label", menu.getName());
                        if (menuList != null && menuList.size() != 0) {
                            map.put("children", getMenuTree(menuList));
                        }
                        list.add(map);
                    }
                }
        );
        return list;
    }

    @Override
    public List<MenuDto> getMenusByname(String name) {
//        if(!ObjectUtils.isEmpty(name)){
        List<Menu> menuList = menuDao.selectList(new QueryWrapper<Menu>().like(!ObjectUtils.isEmpty(name), "name", name));
        List<MenuDto> menuDtoList = new ArrayList<>();
        for (Menu menu : menuList) {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            menuDtoList.add(menuDto);
        }
        return menuDtoList;
//        }
//        return
    }

    @Override
    public void create(Menu menu) {
        if (menuDao.selectOne(new QueryWrapper<Menu>().eq("name", menu.getName())) != null) {
            throw new BaseException(ResultEnum.REPEAD_MENUNAME.getCode(), ResultEnum.REPEAD_MENUNAME.getMessage());
        }
        if (menu.getIFrame()) {
            if (!(menu.getPath().toLowerCase().startsWith("http://") || menu.getPath().toLowerCase().startsWith("https://"))) {
                throw new BaseException(ResultEnum.URL_NOT_STARTWITHHTTP.getCode(), ResultEnum.URL_NOT_STARTWITHHTTP.getMessage());
            }
        }

        menuDao.insert(menu);
    }

    @Override
    public void update(Menu menu) {

        if (menu.getIFrame()) {
            if (!(menu.getPath().toLowerCase().startsWith("http://") || menu.getPath().toLowerCase().startsWith("https://"))) {
                throw new BaseException(ResultEnum.URL_NOT_STARTWITHHTTP.getCode(), ResultEnum.URL_NOT_STARTWITHHTTP.getMessage());
            }
        }


    }

    @Override
    public void delete(Long id) {
        List<Menu> menuList = menuDao.selectList(new QueryWrapper<Menu>().eq("pid", id));
        for (Menu menu : menuList) {
            menuDao.delete(new QueryWrapper<>(menu));
        }
        menuDao.deleteById(id);
    }
}

