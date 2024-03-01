package com.itheima.studentsystemspringbootitaem.mapper;


import com.itheima.studentsystemspringbootitaem.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select *from table_name")
    List<Student> list();

    //新增学生
    @Insert("insert into table_name value (null,#{studentName},#{studentNumber},#{clas},#{phone},#{gender})")
    void addStudent(Student student);

    //删除学生
    @Delete("delete from table_name where id=#{id}")
    void deleteStudent(Integer id);

    //根据Id修改学生的信息
    @Update("update table_name set studentName=#{studentName},studentNumber=#{studentNumber},clas=#{clas},phone=#{phone},gender=#{gender} where id=#{id}")
    void updateStudent(Student student);

    //分页查询
    @Select("select *from table_name limit #{begin},#{size}")
    List<Student> seleteByPage(int begin, int size);

    //分页查询总记录数
    @Select("select count(*) from table_name")
    int seleteTotalCount();

    //批量删除学生数据
    void deleteStudentByIds(int[] ids);

    //分页和条件查询总记录数
    int seleteTotalCountByCondition(Student student);

    //分页和条件查询
    List<Student> seleteByPageAndCondition(int begin, int size, Student student);
}
