package org.example.Learning;

import org.example.FieldTest.Student;

import java.util.*;

/**
 * @author TWAVE
 * @date 2023/8/30 16:29
 */
public class DequeTest {
    public static void main(String[] args) {
        // Deque是一个双端队列，可以在队列的两端插入和移除元素
        // 可以用它来实现栈和队列
        Deque<Integer> stack = new ArrayDeque<>();
        stack.poll();
        TreeMap<Student, Integer> map = new TreeMap<>((s1, s2) -> s2.getName().compareTo(s1.getName()));
        Student student1 = new Student("Alice", 19, 1);
        Student student2 = new Student("Bob", 11, 2);
        Student student3 = new Student("Cline", 14, 3);
        map.put(student1, 1);
        map.put(student2, 2);
        map.put(student3, 3);
        map.forEach((k, v) -> System.out.println(k.getName() + " " + k.getAge() + " " + k.getDaySalary() + " " + v));
        map.entrySet().forEach(System.out::println);
    }
}
