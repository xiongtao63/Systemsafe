package com.example.systemsafe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_user")
public class User {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    private String username;


    private String password;

    @TableField(exist = false)
    List<Permission> permissionList;
}
