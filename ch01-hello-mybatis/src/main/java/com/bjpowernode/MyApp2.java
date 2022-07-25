package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-07-24 10:46
 */
public class MyApp2 {

    public static void main(String[] args) throws IOException {

        // 拿到session对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 6 指定sql语句的标识
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        // 7 执行sql语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        // 8 输出结果
        studentList.forEach(stu -> System.out.println(stu));
        // 9 关闭SqlSession对象
        sqlSession.close();


    }
}
