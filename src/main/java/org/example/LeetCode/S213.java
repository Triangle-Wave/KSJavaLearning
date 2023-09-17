package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/9/17 10:30
 * @finishTime 2023/09/17 10:58:55
 */
public class S213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        int[] dpNoZero = new int[length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dpNoZero[0] = 0;
        dpNoZero[1] = nums[1];
        dpNoZero[2] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < length; i++) {
            if (i < length - 1) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            if (i >= 3) {
                dpNoZero[i] = Math.max(nums[i] + dpNoZero[i - 2], dpNoZero[i - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dpNoZero));
        return Math.max(dp[length - 2], dpNoZero[length - 1]);
    }

    public static void main(String[] args) {
        S213 solution = new S213();
        System.out.println(solution.rob(new int[]{1, 2, 1, 3, 5, 1}));
        System.out.println(solution.rob(new int[]{0, 0}));
        System.out.println(solution.rob(new int[]{200, 3, 140, 20, 10}));
    }
}
