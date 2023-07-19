package org.example;

/**
 * 使用Thread证明++操作不是原子操作
 *
 * @author : twave
 * @date : 2023/7/19 10:05
 */
public class ThreadTest implements Runnable {
    // 定义一个静态变量count，用于进行自增操作
    static int count = 0;

    // 重写run方法，run方法的方法体就是线程执行体
    @Override
    public void run() {
        // 使用for循环自增count变量
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        // 创建线程实例t1，他的线程执行体是ThreadTest的run()方法
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        // 创建线程实例t2，他的线程执行体是ThreadTest的run()方法
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
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
    }
}
