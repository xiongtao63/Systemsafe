package com.example.systemsafe.controller;


import com.example.systemsafe.entity.User;
import com.example.systemsafe.service.UserService;
import com.example.systemsafe.util.TokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private UserService userService;
    @GetMapping("/login")
   public String login(String username, String password){
      return userService.login(username,password);

   }

    @GetMapping("/getUser")
    public String getUser(String token){
        if(token == null || token.isEmpty()){
            return "token不能为空";
        }
        //根据token 查询用户
        User user = TokenUtil.usersMap.get(token);
        if(user == null){
            return "token 无效，请重新登录";
        }
        return user.toString();

    }
}
