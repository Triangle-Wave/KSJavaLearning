package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * Hello world!
 *
 * @author TWAVE
 * @time 2023/7/3
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Deque<Integer> deque1 = new ArrayDeque<Integer>();
        deque1.offerFirst(1);
        deque1.offerLast(2);
        deque1.pollFirst();
        Deque<Integer> deque2 = new ArrayDeque<Integer>();


//        int sum = stack1.pop() + stack2.pop();
//        int a = sum > 10 ? 1 : 0;
//        int b = sum % 10;
//
//        System.out.println(sum);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(stack1);
//        System.out.println(stack2);
    }
}