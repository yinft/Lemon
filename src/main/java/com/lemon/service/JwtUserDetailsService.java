package com.lemon.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.common.untils.ValidationUtil;
import com.lemon.config.auth.JwtUser;
import com.lemon.dao.PermissionDao;
import com.lemon.dao.UserDao;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.Role;
import com.lemon.domain.entity.User;
import com.lemon.domain.vo.UserVo;
import com.lemon.enums.ResultEnum;
import com.lemon.service.PermissionService;
import com.lemon.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @Author: yinft
 * @Date: 2019/1/11 16:53
 * @Version 1.0
 */
@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService  implements UserDetailsService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        if (ValidationUtil.isEmail(username)) {
            user = userDao.selectOne (new QueryWrapper<User>().eq("email", username));
        } else {
            user = userDao.selectOne(new QueryWrapper<User>().eq("username", username));
        }

        if (user == null) {
            throw new BaseException(ResultEnum.USER_DONT_EXISTS.getCode(),ResultEnum.USER_DONT_EXISTS.getMessage());
        } else {

            return create(user);
        }
    }

    public UserDetails create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getEmail(),

                mapToGrantedAuthorities(user.getId()),
                user.getEnabled(),
                user.getCreateTime(),
                user.getUpdateTime()
        );
    }

    private  List<GrantedAuthority> mapToGrantedAuthorities(Long id) {

        Set<Permission> permissions = permissionService.getPermissionsByUserId(id);
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority("ROLE_"+permission.getName()))
                .collect(Collectors.toList());



//        Set<Permission> permissions = new HashSet<>();
//        for (Role role : roles) {
//            Set<Role> roleSet = new HashSet<>();
//            roleSet.add(role);
//            permissions.addAll(permissionService.findByRoles(roleSet));
//        }
//
//        return permissions.stream()
//                .map(permission -> new SimpleGrantedAuthority("ROLE_"+permission.getName()))
//                .collect(Collectors.toList());
    }
}
