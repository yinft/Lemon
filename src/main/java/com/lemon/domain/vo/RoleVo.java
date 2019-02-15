package com.lemon.domain.vo;



import com.lemon.domain.entity.Menu;
import com.lemon.domain.entity.Permission;
import com.lemon.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @Author: yinft
 * @Date: 2019/1/18 16:15
 * @Version 1.0
 */
@Setter
@Getter
public class RoleVo {


    private Integer id;


    private String name;


    private Date createTime;


    private String remark;

    private Set<User> users;

    private Set<Permission> permissions;

    private Set<Menu> menus;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createDateTime=" + createTime +
                '}';
    }

}
