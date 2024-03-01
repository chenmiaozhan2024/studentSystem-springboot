package com.itheima.studentsystemspringbootitaem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String studentName;
    private String studentNumber;
    private Integer clas;
    private String phone;
    private Integer gender;
}
