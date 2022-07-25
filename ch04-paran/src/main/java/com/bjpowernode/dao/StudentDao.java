package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);

    /**
     *    传入多个参数之命名参数
     */
    public List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);


    /**
     * 传入参数之 对象传参
     */
    public List<Student> selectMultiObject(QueryParam queryParam);


    public List<Student> selectMultiStudent(Student student);

    /**
     * 多个参数(简单类型)按位置查询
     */

    public List<Student> selectMultiPosition(String name, Integer age);

    /**
     * 多个参数用map传递
     */
    public List<Student> selectMultiByMap(Map<String, Object> map);

    /**
     * $
     */
    public List<Student> selectUse$(@Param("myname") String mame);

    public List<Student> selectUse$Order(@Param("colName") String colName);
}
