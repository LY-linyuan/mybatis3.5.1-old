package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-07-24 22:05
 */
public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        // 1 定义mybatis主配置文件的名称
        String config = "mybatis.xml";
        // 2 读取这个config文件
        InputStream in =  Resources.getResourceAsStream(config);
        // 3 创建SQlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4 创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        // 5 获取Session队形
        SqlSession sqlSession = factory.openSession();
        // SqlSession sqlSession = factory.openSession(true);   // 自动提交事务
        // 6 指定sql语句的标识
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "InsertStudent";
        // 7 执行sql语句
        Student student = new Student();
        student.setId(6);
        student.setName("张飞");
        student.setEmail("www@zhangfei.com");
        student.setAge(20);
        int count = sqlSession.insert(sqlId, student);
        // 8 输出结果
        System.out.println(count);
        sqlSession.commit();
        // 9 关闭SqlSession对象
        sqlSession.close();
    }
}
