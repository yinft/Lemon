package com.lemon.controller;

import com.lemon.config.auth.JwtUser;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Role;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.MenuVo;
import com.lemon.domain.vo.ResultMap;
import com.lemon.service.MenuService;
import com.lemon.service.PermissionService;
import com.lemon.service.UserService;
import com.lemon.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


/**
 * @Author: yinft
 * @Date: 2019/2/17 22:47
 * @Version 1.0
 */
@Slf4j
@Api(description = "菜单管理")
@RestController
@RequestMapping("api")
public class MenuController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MenuService menuService;

    /**
     * 构建前端路由所需要的菜单
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "构建菜单", notes = "构建菜单", consumes = "application/json")
    @GetMapping(value = "/menus/build")
    public ResultMap<List<MenuVo>> buildMenus(HttpServletRequest request){

        User user = userService.findByName(jwtTokenUtil.getUserName(request));

        List<MenuDto> menuDTOList = menuService.getMenusByUserId(user.getId());
        List<MenuVo> menuVoList=menuService.buildMenus((List<MenuDto>)menuService.buildTree(menuDTOList).get("content"));

        return ResultMap.success(menuVoList);
    }


}
