/*
 * @Author: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @Date: 2023-04-14 15:13:15
 * @LastEditors: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @LastEditTime: 2023-04-14 15:27:54
 * @FilePath: \Java_study\src\study\abstract_demo.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package org.example.Learning;

public class abstract_demo {
    public static void main(String[] args) {
        Salary s = new Salary("Peter", "Ambehta, UP", 3, 3600);
        s.mailCheck();
        System.out.println(s.computePay());
    }
}

abstract class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public abstract double computePay();

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name
                + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {
    private double salary;

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    private void setSalary(double newsalary) {
        salary = newsalary;
    }

    @Override
    public double computePay() {
        System.out.println("the");
        return 25;
    }
}