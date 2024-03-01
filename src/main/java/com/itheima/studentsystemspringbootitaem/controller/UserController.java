package com.itheima.studentsystemspringbootitaem.controller;


import com.itheima.studentsystemspringbootitaem.pojo.Result;
import com.itheima.studentsystemspringbootitaem.pojo.User;
import com.itheima.studentsystemspringbootitaem.service.UserService;
import com.itheima.studentsystemspringbootitaem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //登录功能
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8081") // 允许跨域的来源
    public Result login(@RequestBody User user){
        log.info("用户登录:{}",user);
        User u=userService.login(user);
        //登录成功
        if(u!=null){
            //登录成功
            Map<String,Object> Claims=new HashMap<>();
            Claims.put("id",u.getId());
            Claims.put("username",u.getUsername());
            Claims.put("password",u.getPassword());
            String jwt = JwtUtils.generateJwt(Claims);//包含所有信息
            return Result.success(jwt);
        }
       return Result.error("用户名或者密码错误");
    }

    //注册功能
    @PostMapping("/register")
    public Result register(@RequestBody User user){
      boolean flag=userService.register(user);
      if(flag){
          return Result.success();
      }
        return Result.error("用户名已存在");
    }
}
