package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);


    public List<Student> selectMultiParam(@Param("myname") String name,
                                          @Param("myage") Integer age);

    public ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);


    int countStudent();

    // 定义方法  返回Map
    Map<Object, Object> selectMapById(Integer id);

    /**
     *   使用resultMap定义映射关系
     */
    List<Student> selectAllStudents();


    List<MyStudent> selectAllMyStudents();

    List<MyStudent> selectDiffColProperty();

    /**
     * like 模糊查询  第一种
     */

    List<Student> selectLikeOne(String name);



    /**
     * like 模糊查询  第一种
     */

    List<Student> selectLikeTwo(String name);

}
