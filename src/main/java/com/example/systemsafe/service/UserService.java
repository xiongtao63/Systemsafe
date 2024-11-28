package com.example.systemsafe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.systemsafe.entity.User;

public interface UserService extends IService<User> {
    String login(String username, String password);
}
