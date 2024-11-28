package com.example.systemsafe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.systemsafe.entity.Role;

import com.example.systemsafe.mapper.RoleMapper;
import com.example.systemsafe.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 角色服务实现类
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<Role> selectRoles(Set<Long> roleIds) {
        return baseMapper.selectList(new LambdaQueryWrapper<Role>().in(Role::getId,roleIds));
    }
}
