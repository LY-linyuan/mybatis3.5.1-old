package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
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
public class MyApp {

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
