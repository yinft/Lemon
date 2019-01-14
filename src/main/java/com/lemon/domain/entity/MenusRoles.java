package com.lemon.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: yinft
 * @Date: 2019/1/14 16:11
 * @Version 1.0
 */
@Setter
@Getter
@TableName("menus_roles")
public class MenusRoles extends Model<MenusRoles> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;


}
