package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/9/16 14:33
 */
public class S198 {
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[length];
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[length];
    }

    public static void main(String[] args) {
        S198 solution = new S198();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
