package com.example.systemsafe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.systemsafe.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService extends IService<Role> {
    /**
     * 根据角色id 获取角色列表
     * @param roleIds
     * @return
     */
    List<Role> selectRoles(Set<Long> roleIds);
}
