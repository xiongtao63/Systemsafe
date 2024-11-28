package com.example.systemsafe.util;

import com.example.systemsafe.entity.User;

import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    public static Map<String, User> usersMap= new HashMap<>();

    public static final String salt = "imooc";

    public static String createToken(User user){
        String token= user.getId() + salt;
        usersMap.put(token,user);
        return token;
    }
}
