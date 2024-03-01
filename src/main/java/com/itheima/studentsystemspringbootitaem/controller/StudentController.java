package com.itheima.studentsystemspringbootitaem.controller;


import com.itheima.studentsystemspringbootitaem.pojo.PageBean;
import com.itheima.studentsystemspringbootitaem.pojo.Result;
import com.itheima.studentsystemspringbootitaem.pojo.Student;
import com.itheima.studentsystemspringbootitaem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //查询全部学生
    @GetMapping("/student")
    public Result list(){
        log.info("查询所有学生信息");
        List<Student> studentList= studentService.list();
        return Result.success(studentList);
    }

    //新增学生
    @PostMapping("student")
    public Result addStudent(@RequestBody Student student){
        log.info("新增学生:{}",student);
        studentService.addStudent(student);
        return Result.success();
    }

    //删除学生
    @DeleteMapping("student/{id}")
    public Result deleteStudent(@PathVariable Integer id){
        log.info("删除学生:{}");
        studentService.deleteStudent(id);
        return Result.success();
    }

    //根据id修改学生的信息
    @PutMapping("/student")
    public Result updateStudent(@RequestBody Student student){
        log.info("根据id修改学生信息:{}",student);
        studentService.updateStudent(student);
        return Result.success();
    }

    //分页查询
    @GetMapping("students")
    public Result page(@RequestParam int currentPage, int pageSize){
        log.info("分页查询:{},{}",currentPage,pageSize);
        PageBean<Student> studentPageBean=studentService.page(currentPage,pageSize);
        return Result.success(studentPageBean);
    }

    //批量删除
   @DeleteMapping("students")
    public Result deleteByIds(@RequestBody int[] ids){
        log.info("批量删除:{}");
        studentService.deleteStudentByIds(ids);
        return Result.success();
    }

    //分页和条件查询
    @PostMapping("students")
    public Result seleteByPageAndCondition(@RequestParam(value = "currentPage", required = false) Integer currentPage,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                           @RequestBody Student student) {
        PageBean<Student> pageBean = studentService.seleteByPageAndCondition(currentPage, pageSize, student);
        return Result.success(pageBean);
    }
}
