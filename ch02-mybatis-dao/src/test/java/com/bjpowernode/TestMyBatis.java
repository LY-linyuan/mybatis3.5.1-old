package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-07-25 12:10
 */
public class TestMyBatis {
    @Test
    public void testSelectStudents() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.selectStudents();
        studentList.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudents() {
        Student student = new Student();
        student.setId(7);
        student.setName("刘备");
        student.setEmail("www@zhangfei.com");
        student.setAge(20);
        StudentDao studentDao = new StudentDaoImpl();
        int count = studentDao.insertStudent(student);
        System.out.println(count);
    }
}
