package com.lemon.controller;

import com.lemon.common.constant.Constants;
import com.lemon.domain.dto.MenuDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.MenuVo;
import com.lemon.domain.vo.ResultMap;
import com.lemon.enums.ResultEnum;
import com.lemon.service.MenuService;
import com.lemon.service.LoginService;
import com.lemon.utils.JwtTokenUtil;
import com.lemon.utils.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


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
    private LoginService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MenuService menuService;

    /**
     * 构建前端组件路由所需要的菜单
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "构建前端组件路由菜单", notes = "构建前端组件路由菜单", consumes = "application/json")
    @GetMapping(value = "/menus/build")
    public ResultMap<List<MenuVo>> buildMenus(HttpServletRequest request){
        User user = userService.findByName(jwtTokenUtil.getUserName(request));
        List<MenuDto> menuDTOList = menuService.getMenusByUserId(user.getId());
        List<MenuVo> menuVoList=menuService.buildMenus((List<MenuDto>)menuService.buildTree(menuDTOList).get("content"));
        return ResultMap.success(menuVoList);
    }

    /**
     * 返回全部的菜单
     * @return
     */
    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "全部菜单树", notes = "全部菜单树", consumes = "application/json")
    @GetMapping(value = "/menus/tree")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResultMap<List> getMenuTree(){
       List  list=menuService.getMenuTree(menuService.getByPid(0L));
       return ResultMap.success(list);
    }



    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "查询菜单", notes = "查询菜单", consumes = "application/json")
    @GetMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_SELECT')")
    public ResultMap<Map> getMenus(@RequestParam(required = false) String name){
        List<MenuDto> menuDTOList= menuService.getMenusByname(name);
        Map map= menuService.buildTree(menuDTOList);
        return ResultMap.success(map);
    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "新增菜单", notes = "新增菜单", consumes = "application/json")
    @PostMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE')")
    public ResultMap creatMenus(@Validated @RequestBody Menu menu){
        if (menu.getId() != null) {
            throw new BaseException(ResultEnum.REPEAD_ID.getCode(),ResultEnum.REPEAD_ID.getMessage());
        }
      menuService.create(menu);
       return ResultMap.success();
    }


    @ApiImplicitParam(paramType = "header", name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "修改菜单", notes = "修改菜单", consumes = "application/json")
    @PutMapping(value = "/menus")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_EDIT')")
    public ResultMap updateMenus(@Validated @RequestBody Menu menu){
        if (menu.getId() == null) {
            throw new BaseException(ResultEnum.NULL_ID.getCode(),ResultEnum.NULL_ID.getMessage());
        }
        menuService.update(menu);
        return ResultMap.success();
    }


    @ApiImplicitParam(paramType = "header",name = Constants.TOKEN_HEADER_NAME, defaultValue = "Bearer ")
    @ApiOperation(value = "删除菜单", notes = "删除菜单", consumes = "application/json")
    @DeleteMapping(value = "/menus/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_DELETE')")
    public ResultMap deleteMenus(@PathVariable Long id){
        menuService.delete(id);
        return ResultMap.success();
    }

}
