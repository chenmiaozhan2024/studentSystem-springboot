package com.itheima.studentsystemspringbootitaem.mapper;

import com.itheima.studentsystemspringbootitaem.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //根据用户名和密码去查询对象
    @Select("select *from tb_user where username=#{username} and password=#{password}")
    User select(String username, String password);

    //根据用户名去查询对象
    @Select("select *from tb_user where username=#{username}")
    User selectByUserName(String userName);

    //添加用户
    @Insert("insert into tb_user values (null,#{username},#{password})")
    void addUser(User user);
}
