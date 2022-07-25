package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    // 查询Student表中的所有数据
    public List<Student> selectStudents();

    public int InsertStudent(Student student);
}
