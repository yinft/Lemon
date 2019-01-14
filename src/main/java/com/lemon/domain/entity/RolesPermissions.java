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
 * @Date: 2019/1/14 16:16
 * @Version 1.0
 */
@Setter
@Getter
@TableName("roles_permissions")
public class RolesPermissions extends Model<RolesPermissions> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;



    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;


    /**
     * 角色对应的资源ID
     */
    @TableField("permission_id")
    private Long permissionId;


}
