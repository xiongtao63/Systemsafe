package com.example.systemsafe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.systemsafe.entity.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {
    /**
     * 根据用户id查询角色信息list
     * @param userId
     * @return
     */
    List<UserRole> getList(Long userId);
}
