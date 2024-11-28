package com.example.systemsafe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色关联表
 */
@Data
@TableName("t_user_role")
public class UserRole {



    private Long userId;

    private Long roleId;


}
