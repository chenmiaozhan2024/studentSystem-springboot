package com.itheima.studentsystemspringbootitaem.service;




import com.itheima.studentsystemspringbootitaem.pojo.PageBean;
import com.itheima.studentsystemspringbootitaem.pojo.Student;

import java.util.List;

public interface StudentService {
    //查询所有课程信息
    List<Student> list();

    //新增学生
    void addStudent(Student student);

    //删除学生
    void deleteStudent(Integer id);

    //根据Id修改学生的信息
    void updateStudent(Student student);

    //进行分页查询
    PageBean<Student> page(int currentPage, int pageSize);

    //批量删除
    void deleteStudentByIds(int[] ids);

    //分页和条件查询
    PageBean<Student> seleteByPageAndCondition(Integer currentPage, Integer pageSize, Student student);
}
