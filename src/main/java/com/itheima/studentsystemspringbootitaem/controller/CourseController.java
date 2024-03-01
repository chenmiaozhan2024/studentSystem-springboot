package com.itheima.studentsystemspringbootitaem.controller;


import com.itheima.studentsystemspringbootitaem.pojo.Course;
import com.itheima.studentsystemspringbootitaem.pojo.PageBean;
import com.itheima.studentsystemspringbootitaem.pojo.Result;
import com.itheima.studentsystemspringbootitaem.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    //查询全部课程信息
    @GetMapping("/courses")
    public Result list() {
        log.info("查询全部课程信息");
        List<Course> courseList = courseService.list();
        return Result.success(courseList);
    }

    //新增课程
    @PostMapping("/course")
    public Result addCourse(@RequestBody Course course) {
        log.info("新增课程:{}", course);
        courseService.addCourse(course);
        return Result.success();
    }

    //根据id删除课程
    @DeleteMapping("/course/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("根据id删除课程:{}", id);
        courseService.deleteCourse(id);
        return Result.success();
    }

    //根据id修改数据
    @PutMapping("/course")
    public Result updateCourse(@RequestBody Course course) {
        log.info("根据id修改数据:{}", course);
        courseService.updateCourse(course);
        return Result.success();
    }

    //分页查询
    @GetMapping("/course")
    public Result seleteByPage(@RequestParam int currentPage, int pageSize) {
        log.info("分页查询:{},{}", currentPage, pageSize);
        PageBean<Course> pageBean = courseService.seleteByPage(currentPage, pageSize);
        return Result.success(pageBean);
    }

    //批量删除
    @DeleteMapping("courses")
    public Result deleteByIds(@RequestBody int[] ids) {
        courseService.deleteByIds(ids);
        return Result.success();
    }


    //分页和条件查询
    @PostMapping("courses")
    public Result seleteByPageAndCondition(@RequestParam(value = "currentPage", required = false) Integer currentPage,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                           @RequestBody Course course) {
        PageBean<Course> pageBean = courseService.seleteByPageAndCondition(currentPage, pageSize, course);
        return Result.success(pageBean);
    }


}
