package org.example.FieldTest;

/**
 * 这是一个测试类，名称为Student
 * 有三个属性，分别是姓名name，年龄age和日工资daySalary
 * 这个类只有get方法，没有set方法，用于测试如何利用反射给属性赋值
 *
 * @author : twave
 * @date : 2023/7/14 8:34
 */
public class Student {
    private String name;
    private int age;
    private double daySalary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getDaySalary() {
        return daySalary;
    }
}
