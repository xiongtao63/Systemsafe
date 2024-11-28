package com.example.systemsafe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_role")
public class Role {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    private String roleName;


}
