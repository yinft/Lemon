package com.lemon.controller;

import com.lemon.domain.entity.User;
import com.lemon.service.UserService;
import com.lemon.utils.JwtTokenUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: yinft
 * @Date: 2019/2/17 22:47
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class MenuController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 构建前端路由所需要的菜单
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = "Authorization", defaultValue = "Bearer ")
    @ApiOperation(value = "构建菜单", notes = "构建菜单", consumes = "application/json")
    @GetMapping(value = "/menus/build")
    public ResponseEntity buildMenus(HttpServletRequest request){
        User user = userService.findByName(jwtTokenUtil.getUserName(request));
        List<MenuDTO> menuDTOList = menuService.findByRoles(user.getRoles());
        return new ResponseEntity(menuService.buildMenus((List<MenuDTO>)menuService.buildTree(menuDTOList).get("content")),HttpStatus.OK);
    }


}
