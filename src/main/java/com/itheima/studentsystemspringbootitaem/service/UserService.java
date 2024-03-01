package com.itheima.studentsystemspringbootitaem.service;


import com.itheima.studentsystemspringbootitaem.pojo.User;

public interface UserService {

    //登录功能
    User login(User user);

    //注册功能
    boolean register(User user);



}
