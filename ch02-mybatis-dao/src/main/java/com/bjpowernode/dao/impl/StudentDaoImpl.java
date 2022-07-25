package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-07-25 12:01
 */
public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> selectStudents() {
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";
        int count = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
