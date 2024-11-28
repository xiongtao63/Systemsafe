package com.example.systemsafe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.systemsafe.entity.Permission;
import com.example.systemsafe.entity.Role;
import com.example.systemsafe.entity.User;
import com.example.systemsafe.entity.UserRole;
import com.example.systemsafe.mapper.UserMapper;
import com.example.systemsafe.service.RoleService;
import com.example.systemsafe.service.UserRoleService;
import com.example.systemsafe.service.UserService;
import com.example.systemsafe.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;
    @Override
    public String login(String username, String password) {
        //判断用户名是否存在
        LambdaQueryWrapper<User> eq = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        User user = baseMapper.selectOne(eq);
        if(Objects.isNull(user)){
            return "用户名不存在";
        }
        //判断密码是否正确
        if(!Objects.equals(user.getPassword(), password)){
            return "用户名或者密码不正确";
        }
        //根据用户查询用户角色信息

        List<UserRole> userRoleList = userRoleService.getList(user.getId());
        if(userRoleList.isEmpty()){
            return "当前用户没有角色";
        }

        Set<Long> roleIds = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
        List<Role> roles = roleService.selectRoles(roleIds);

//        List<Permission> permissionList = baseMapper.findPerms(user.getId());
        List<Permission> permissionList = baseMapper.findRolePerms(user.getId());
        log.info("用户所拥有的权限列表为："+ permissionList);
        user.setPermissionList(permissionList);

        //传教一个token 返回给前端
        String token = TokenUtil.createToken(user);
        log.info("成功创建用户token: "+token);



        return token;
    }
}
