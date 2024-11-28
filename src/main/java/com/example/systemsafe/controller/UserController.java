package com.example.systemsafe.controller;


import com.example.systemsafe.entity.User;
import com.example.systemsafe.service.UserService;
import com.example.systemsafe.util.DESUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
         user.setUsername(DESUtil.getEncryptString(user.getUsername()));
         userService.save(user);
        return "success";
    }

    @GetMapping("/query")
    public String query(String userId){
        User user = userService.getById(userId);
        user.setUsername(DESUtil.getDecryptString(user.getUsername()));
        return user.toString();
    }
}
