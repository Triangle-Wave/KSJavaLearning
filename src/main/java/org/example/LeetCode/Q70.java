package org.example.LeetCode;

/**
 * @author TWAVE
 * 爬n阶楼梯，一次可以上1或2阶，有几种方法？
 */
public class Q70 {
    public static void main(String[] args) {
        SolutionQ70 solution = new SolutionQ70();
        System.out.println(solution.climbStairs(5));
    }
}

class SolutionQ70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int p, q = 1, r = 2;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}