package com.lemon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.dao.UserDao;
import com.lemon.domain.dto.PageParamDTO;
import com.lemon.domain.dto.UserAddDTO;
import com.lemon.domain.dto.UserDto;
import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.User;
import com.lemon.domain.entity.UsersRoles;
import com.lemon.domain.vo.UserVo;
import com.lemon.enums.ResultEnum;
import com.lemon.service.MenuService;
import com.lemon.service.UserService;
import com.lemon.service.UsersRolesService;
import com.lemon.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinft
 * @Date: 2019/2/28 21:15
 * @Version 1.0
 */
@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private static final String PASSWORD = "14e1b600b1fd579f47433b88e8d85291";

    private static final String AVATAR = "https://i.loli.net/2018/12/06/5c08894d8de21.jpg";


    @Autowired
    private UserDao userDao;

    @Autowired
    private UsersRolesService usersRolesService;


    @Override
    public IPage<UserVo> getUserPage(PageParamDTO pageParamDTO, UserDto userDTO) {
        Page<UserVo> myPage = new Page<>(pageParamDTO.getCurrent(), pageParamDTO.getSize());
        IPage<UserVo> iPage = userDao.page(myPage, userDTO);
        return iPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(UserAddDTO userAddDTO) {
        if (userDao.selectOne(new QueryWrapper<User>().eq("username", userAddDTO.getUsername())) != null) {

            throw new BaseException(ResultEnum.REPEAD_USERNAME.getCode(), ResultEnum.REPEAD_USERNAME.getMessage());
        }
        if (userDao.selectOne(new QueryWrapper<User>().eq("email", userAddDTO.getEmail())) != null) {
            throw new BaseException(ResultEnum.REPEAD_EMAIL.getCode(), ResultEnum.REPEAD_EMAIL.getMessage());
        }
        // 默认密码 123456
        userAddDTO.setPassword(PASSWORD);
        userAddDTO.setAvatar(AVATAR);
        userDao.insertAndGetId(userAddDTO);
        insertUserRole(userAddDTO.getId(), userAddDTO.getRoleIds());

        String [] sum2 = {"张山","历史","你好","哈哈"};
        System.out.println(sum2);
    }


    /**
     * 新增用户角色关联信息
     *
     * @param
     */
    public void insertUserRole(Long userId, List<Long> roleIds) {
        // 新增用户与角色关联
        List<UsersRoles> list = new ArrayList<>();
        for (Long roleId : roleIds) {
            UsersRoles ur = new UsersRoles();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
//            usersRolesService.insertBatch(list);
            usersRolesService.saveBatch(list);
        }

    }

    @Override
    public void delete(Long id) {
        /**
         * 根据实际需求,超级管理员用户无法删除
         */
        if (id.equals(1L)) {
            throw new BaseException(ResultEnum.CAN_NOT_DELETACCOUNT.getCode(), ResultEnum.CAN_NOT_DELETACCOUNT.getMessage());
        }
        userDao.deleteById(id);
    }

    @Override
    public void update(User user) {
        /**
         * 根据实际需求,超级管理员用户无法修改
         */
        if (user.getId().equals(1L)) {
            throw new BaseException(ResultEnum.CAN_NOT_UPDATEACCOUNT.getCode(), ResultEnum.CAN_NOT_UPDATEACCOUNT.getMessage());
        }
        userDao.updateById(user);

    }
}
