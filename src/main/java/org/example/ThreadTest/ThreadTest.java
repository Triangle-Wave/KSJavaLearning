package org.example.ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Thread证明++操作不是原子操作
 *
 * @author : twave
 * @date : 2023/7/19 10:05
 */
public class ThreadTest {
    // 定义一个静态变量count，用于进行自增操作
    static int count = 0;
    static AtomicInteger acount;

    public static void main(String[] args) {
        acount = new AtomicInteger();
        // 创建线程实例t1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                acount.getAndIncrement();
            }
        });

        // 创建线程实例t2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                acount.getAndIncrement();
            }
        });

        // 两个线程同时对count进行自增操作
        t1.start();
        t2.start();

        try {
            // 等待两个线程执行完毕
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        System.out.println(acount);
    }
}
