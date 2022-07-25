package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-07-25 12:10
 */
public class TestMyBatis {
    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("StudentDao" + studentDao.getClass().getName());    // StudentDaocom.sun.proxy.$Proxy2 JDK的动态代理
        List<Student> studentList = studentDao.selectStudents();
        studentList.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudents() {
        Student student = new Student();
        student.setId(8);
        student.setName("盾山");
        student.setEmail("www@zhangfei.com");
        student.setAge(22);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        int count = studentDao.insertStudent(student);
        sqlSession.commit();
        System.out.println(count);
    }
}
