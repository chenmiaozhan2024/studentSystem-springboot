package com.itheima.studentsystemspringbootitaem.service.impl;


import com.itheima.studentsystemspringbootitaem.mapper.StudentMapper;
import com.itheima.studentsystemspringbootitaem.pojo.PageBean;
import com.itheima.studentsystemspringbootitaem.pojo.Student;
import com.itheima.studentsystemspringbootitaem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public PageBean<Student> page(int currentPage, int pageSize) {
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
       List<Student> rows=studentMapper.seleteByPage(begin,size);
       int totalCount=studentMapper.seleteTotalCount();
        //封装对象
        PageBean<Student> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotal(totalCount);
        return pageBean;
    }

    @Override
    public void deleteStudentByIds(int[] ids) {
        studentMapper.deleteStudentByIds(ids);
    }

    @Override
    public PageBean<Student> seleteByPageAndCondition(Integer currentPage, Integer pageSize, Student student) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        //模糊表达式
        String studentName = student.getStudentName();
        if(studentName !=null&&studentName.length()>0){
            student.setStudentName("%"+studentName+"%");
        }
        String studentNumber = student.getStudentNumber();
        if(studentNumber !=null&&studentNumber.length()>0){
            student.setStudentNumber("%"+studentNumber+"%");
        }
       List<Student> rows=studentMapper.seleteByPageAndCondition(begin, size, student);
        int totalCount = studentMapper.seleteTotalCountByCondition(student);
        //封装PageBean对象
        PageBean<Student> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotal(totalCount);
        return pageBean;
    }


}
