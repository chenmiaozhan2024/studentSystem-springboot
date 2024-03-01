package com.itheima.studentsystemspringbootitaem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
分页查询结果的封装类
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private long total;//总记录数
    private List<T> rows;//数据列表
}
