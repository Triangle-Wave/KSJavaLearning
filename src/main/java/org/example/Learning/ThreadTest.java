package org.example.Learning;

/**
 * @author : twave
 * @date : 2023/7/14 9:21
 */
public class ThreadTest {

    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;

    // 共享对象，作为锁和通信的媒介
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        // 创建三个线程
        // Thread()中直接使用lambda表达式
        Thread threadA = new Thread(() -> {
            try {
                // 循环100次
                for (int i = 0; i < 100; i++) {
                    // 获取锁
                    synchronized (LOCK) {
                        // 判断是否轮到自己执行
                        while (state % 3 != 0) {
                            // 不是则等待
                            // wait()方法会释放锁
                            LOCK.wait();
                        }
                        // 打印字母
                        System.out.println("A");
                        // 修改状态
                        state++;
                        // 唤醒下一个线程
                        // notifyAll()方法会唤醒所有wait()的线程，但是只有一个线程能获取到锁
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    synchronized (LOCK) {
                        while (state % 3 != 1) {
                            LOCK.wait();
                        }
                        System.out.println("B");
                        state++;
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    synchronized (LOCK) {
                        while (state % 3 != 2) {
                            LOCK.wait();
                        }
                        System.out.println("C");
                        state++;
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动三个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

