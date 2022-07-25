package com.bjpowernode;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
        Student student = new Student();
        // 第一个条件必须有 或者 加一个 where 1 = 1
        student.setAge(21);
        student.setName("张三");
        List<Student> studentList = studentDao.selectStudentIf(student);
        for (Student student1: studentList) {
            System.out.println(student1);
        }
    }


    @Test
    public void testSelectStudentWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(21);
        student.setName("张三");
        List<Student> studentList = studentDao.selectStudentWhere(student);
        for (Student student1: studentList) {
            System.out.println(student1);
        }
    }

    @Test
    public void testFor() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        //    String sql = "select id, name, email, age from student where id in (1, 2, 3)";
        String sql = "select id, name, email, age from student where id in";
        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();
        builder.append("(");
        for (Integer i : list) {
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        sql = sql + builder;
        System.out.println(sql);

    }

    @Test
    public void testSelectForeachOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Student> studentList = studentDao.selectForeachOne(list);
        for (Student student1: studentList) {
            System.out.println(student1);
        }
    }


    @Test
    public void testSelectForeachTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setId(1);
        Student student2 = new Student();
        student2.setId(4);
        Student student3 = new Student();
        student3.setId(5);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        List<Student> studentList0 = studentDao.selectForeachTwo(studentList);
        for (Student student: studentList0) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        // 加入pageHelper的方法分页
        // pageName  第几页  从一开始
        // pagesize  一页中有多少行
        PageHelper.startPage(2, 3);
        List<Student> studentList = studentDao.selectAll();
        for (Student student1: studentList) {
            System.out.println(student1);
        }
    }





}
