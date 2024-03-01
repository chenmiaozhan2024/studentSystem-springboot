package com.itheima.studentsystemspringbootitaem.service;



import com.itheima.studentsystemspringbootitaem.pojo.Course;
import com.itheima.studentsystemspringbootitaem.pojo.PageBean;

import java.util.List;

public interface CourseService {
    //查询全部课程信息
    List<Course> list();


    //新增课程
    void addCourse(Course course);

    //根据id删除课程
    void deleteCourse(Integer id);

    //根据id更新数据
    void updateCourse(Course course);

    //分页查询
    PageBean<Course> seleteByPage(int currentPage, int pageSize);

    //批量删除
    void deleteByIds(int[] ids);

    //分页和条件查询
    PageBean<Course> seleteByPageAndCondition(int currentPage, int pageSize, Course course);

}
