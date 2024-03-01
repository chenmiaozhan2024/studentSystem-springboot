package com.itheima.studentsystemspringbootitaem.service.impl;


import com.itheima.studentsystemspringbootitaem.mapper.UserMapper;
import com.itheima.studentsystemspringbootitaem.pojo.User;
import com.itheima.studentsystemspringbootitaem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);
        User u = userMapper.select(username, password);
        return u;
    }


    //注册功能
    @Override
    public boolean register(User user) {
        //获取用户名
        String username = user.getUsername();
        User u = userMapper.selectByUserName(username);
        if(u==null&&username.length()>0){
            //用户名不存在，进行注册
            userMapper.addUser(user);
            return true;
        }
        return false;
    }


}
