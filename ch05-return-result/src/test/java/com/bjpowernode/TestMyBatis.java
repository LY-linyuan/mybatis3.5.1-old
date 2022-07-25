package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Student student = studentDao.selectStudentById(6);
        System.out.println(student);
    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectMultiParam("张飞", 22);
        studentList.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectStudentReturnViewStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent = studentDao.selectStudentReturnViewStudent( 1);
        System.out.println(viewStudent);
    }


    @Test
    public void testCountStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Integer count = studentDao.countStudent();
        System.out.println(count);
    }


    @Test
    public void testSelectMapById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = studentDao.selectMapById(1);
        System.out.println(map);

    }

    @Test
    public void testSelectAllStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectAllStudents();
        for (Student student: studentList) {
            System.out.println(student);
        }

    }


    @Test
    public void testSelectAllMyStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudentList = studentDao.selectAllMyStudents();
        for (MyStudent myStudent: myStudentList) {
            System.out.println(myStudent);
        }

    }


    @Test
    public void testSelectDiffColProperty() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudentList = studentDao.selectDiffColProperty();
        for (MyStudent myStudent: myStudentList) {
            System.out.println(myStudent);
        }

    }


    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList  = studentDao.selectLikeOne("%张%");
        for (Student student: studentList) {
            System.out.println(student);
        }

    }


    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList  = studentDao.selectLikeTwo("张");
        for (Student student: studentList) {
            System.out.println(student);
        }

    }





}
