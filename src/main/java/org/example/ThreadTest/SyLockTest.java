package org.example.ThreadTest;

/**
 * @author : twave
 * @date : 2023/7/19 11:11
 */
public class SyLockTest implements Runnable {
    // 定义一个静态变量count，用于进行自增操作
    static int count = 0;

    // 定义一个同步方法，使用synchronized锁保证线程安全，用于对count变量进行自增操作
    // public synchronized void increment() {
    //     // 获取线程名称
    //     String threadName = Thread.currentThread().getName();
    //     // 如果count是1000的倍数，就打印线程名称
    //     if (count % 1000 == 0) {
    //         System.out.printf("线程名：%s, count = %d%n", threadName, count);
    //     }
    //     count++;
    // }
    public void increment() {
        String threadName = Thread.currentThread().getName();
        if (count % 1000 == 0) {
            System.out.printf("线程名：%s, count = %d%n", threadName, count);
        }
        // 除了锁方法,还可以锁代码块
        synchronized (this) {
            count++;
        }
    }

    // 重写run方法，run方法的方法体就是线程执行体
    @Override
    public void run() {
        // 使用for循环调用increment方法
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }

    public static void main(String[] args) {
        // 创建实例
        SyLockTest test = new SyLockTest();

        // 创建线程实例t1和t2，它们的线程执行体都是test的run()方法
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

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
