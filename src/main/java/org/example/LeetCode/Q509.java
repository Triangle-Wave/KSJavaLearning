package org.example.LeetCode;

/**
 * @author TWAVE
 * 求斐波那契数列的第n项
 */
public class Q509 {
    public static void main(String[] args) {
        SolutionQ509 solution = new SolutionQ509();
        System.out.println(solution.fib(5));
    }
}

class SolutionQ509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}