package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/9/20 10:45
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += coin / 2 + coin % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        LCP06 solution = new LCP06();
        System.out.println(solution.minCount(new int[]{4, 2, 1}));
        System.out.println(solution.minCount(new int[]{2, 3, 10}));
    }
}
