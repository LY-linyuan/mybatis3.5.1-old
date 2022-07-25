package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
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
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("盾山");
        queryParam.setParamAge(22);
        List<Student> studentList = studentDao.selectMultiObject(queryParam);
        studentList.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("盾山");
        student.setAge(20);
        List<Student> studentList = studentDao.selectMultiStudent(student);
        studentList.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testTelectMultiPosition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectMultiPosition("盾山", 22);
        studentList.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testSelectMultiByMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张飞");
        map.put("age", 22);
        List<Student> studentList = studentDao.selectMultiByMap(map);
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectUse$() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectUse$("'张飞'");
        // List<Student> studentList = studentDao.selectUse$("'张飞 where 1=1'");
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectUse$Order() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
//        List<Student> studentList = studentDao.selectUse$Order("age");
//        List<Student> studentList = studentDao.selectUse$Order("email");
         List<Student> studentList = studentDao.selectUse$Order("name");
        for (Student student: studentList) {
            System.out.println(student);
        }
    }


}
