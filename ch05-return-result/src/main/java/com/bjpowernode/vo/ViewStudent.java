package com.bjpowernode.vo;

/**
 * @Author 临渊
 * @Date 2022-07-25 18:23
 */
public class ViewStudent {

    // 定义属性
    private Integer id;
    private String name;


    @Override
    public String toString() {
        return "viewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    }
