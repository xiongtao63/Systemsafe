package com.example.systemsafe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_permission")
public class Permission {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    private String perName;


    private String perUrl;
}
