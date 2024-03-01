package com.itheima.studentsystemspringbootitaem.service.impl;

import com.itheima.studentsystemspringbootitaem.mapper.CourseMapper;
import com.itheima.studentsystemspringbootitaem.pojo.Course;
import com.itheima.studentsystemspringbootitaem.pojo.PageBean;
import com.itheima.studentsystemspringbootitaem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
   private CourseMapper courseMapper;

    //查询全部课程信息
    @Override
    public List<Course> list() {
        return courseMapper.list();
    }

    //新增课程
    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    //根据id删除课程
    @Override
    public void deleteCourse(Integer id) {
        courseMapper.deleteCourse(id);
    }

    //更新课程
    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    //分页查询
    @Override
    public PageBean<Course> seleteByPage(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Course> rows = courseMapper.seleteByPage(begin, size);
        int totalCount = courseMapper.seleteTotalCount();
        //封装对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotal(totalCount);
        return pageBean;
    }

    //批量删除
    @Override
    public void deleteByIds(int[] ids) {
        courseMapper.deleteByIds(ids);
    }

    //分页和条件查询
    @Override
    public PageBean<Course> seleteByPageAndCondition(int currentPage, int pageSize, Course course) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        //模糊表达式
        String courseName = course.getCourseName();
        if (courseName != null && courseName.length() > 0) {
            course.setCourseName("%" + courseName + "%");
        }
        String teacher = course.getTeacher();
        if (teacher != null && teacher.length() > 0) {
            course.setTeacher("%" + teacher + "%");
        }
        List<Course> rows = courseMapper.seleteByPageAndCondition(begin, size, course);
        int totalCount = courseMapper.seleteTotalCountByCondition(course);
        //封装PageBean对象
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotal(totalCount);
        return pageBean;
    }


}
