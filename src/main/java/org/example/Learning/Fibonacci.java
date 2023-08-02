package org.example.Learning;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 30;
        int result = fibonacci(n);
        System.out.println("第" + n + "个斐波那契数为：" + result);
    }
}
