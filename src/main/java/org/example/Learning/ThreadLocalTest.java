package org.example.Learning;

import java.io.IOException;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) throws IOException {
        threadLocal1.set("1123");
        test();
        threadLocal1.remove();
        threadLocal1 = null;
    }

    public static void test() {
        String s1 = ThreadLocalTest.threadLocal1.get();
        System.out.println(s1);
    }
}
