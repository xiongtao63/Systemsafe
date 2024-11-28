package com.example.systemsafe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.systemsafe.entity.Permission;
import com.example.systemsafe.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 基于ACL  根据用户id 获取权限列表
     * @param userId
     * @return
     */
    List<Permission> findPerms(@Param("userId") Long userId);

    /**
     * 基于RBAC
     * @param userId
     * @return
     */
    List<Permission> findRolePerms(@Param("userId") Long userId);
}
