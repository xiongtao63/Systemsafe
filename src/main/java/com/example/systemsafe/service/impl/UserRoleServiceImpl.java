package com.example.systemsafe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.systemsafe.entity.UserRole;
import com.example.systemsafe.mapper.UserRoleMapper;
import com.example.systemsafe.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联服务实现类
 */
@Service
@Slf4j
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
    @Override
    public List<UserRole> getList(Long userId) {

        return baseMapper.selectList(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId));
    }
}
