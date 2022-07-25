package com.bjpowernode.dao;


import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 动态sql  java对象作为参数
     */
    List<Student> selectStudentIf(Student student);

    /**
     *  动态sql where 标签
     */
    List<Student> selectStudentWhere(Student student);

    /**
     * foreach标签  用法1
     */
    List<Student> selectForeachOne(List<Integer> idList);

    /**
     * foreach  用法二
     */
    List<Student> selectForeachTwo(List<Student> studentList);

    /**
     * sql  片段
     */

    /**
     *   pageHelper分页数据
     */
    List<Student> selectAll();

}
