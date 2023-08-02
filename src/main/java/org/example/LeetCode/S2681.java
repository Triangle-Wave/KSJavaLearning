package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author : twave
 * @date : 2023/8/1 13:48
 */
public class S2681 {
    public int sumOfPower(int[] nums) {
        // Arrays.sort(nums);
        // int result = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         // Java求幂指数用Math.pow()，返回值是double类型
        //         int res = j - i > 1 ? (int) Math.pow(2, (j - i - 1)) : 1;
        //         result += nums[j] * nums[j] * nums[i] * res;
        //     }
        // }
        // return result % 1000000007;
        final long mod = (long) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        for (long num : nums) {
            ans = (ans + num * num % mod * (num + s)) % mod;
            s = (s * 2 + num) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        S2681 solution = new S2681();
        int[][] nums = new int[][]{
                {1, 5, 2, 3},
                {2, 1, 4},
                {1, 1, 1},
                {1, 5, 9, 7, 2, 8, 1},
                {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}
        };
        for (int[] num : nums) {
            System.out.println(solution.sumOfPower(num));
        }
    }
}
