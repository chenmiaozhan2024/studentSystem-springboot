package com.itheima.studentsystemspringbootitaem.mapper;


import com.itheima.studentsystemspringbootitaem.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    //查询全部课程信息
    @Select("select *from table_course")
    List<Course> list();

    //新增课程
    @Insert("insert into table_course (courseName, address, people, learningStyle, teacher, credit) VALUE (#{courseName},#{address},#{people},#{learningStyle},#{teacher},#{credit})")
    void addCourse(Course course);

    //根据id删除课程
    @Delete("delete from table_course where id=#{id}")
    void deleteCourse(Integer id);

    //根据ID更新数据
    @Update("update table_course set courseName=#{courseName},people=#{people},address=#{address},teacher=#{teacher},learningStyle=#{learningStyle},credit=#{credit} where id=#{id}")
    void updateCourse(Course course);

    //分页查询
    @Select("select *from table_course limit #{begin},#{size}")
    List<Course> seleteByPage(int begin, int size);

    //查询总记录数
    @Select("select count(*) from table_course")
    int seleteTotalCount();

    //批量删除
    void deleteByIds(int[] ids);

    //分页查询和条件查询
    List<Course> seleteByPageAndCondition(int begin, int size, Course course);

    //查询总记录数
    int seleteTotalCountByCondition(Course course);


}
