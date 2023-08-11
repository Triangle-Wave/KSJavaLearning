package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/8/10 20:41
 */
public class S1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        System.arraycopy(grid[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        S1289 s1289 = new S1289();
        System.out.println(s1289.minFallingPathSum(matrix));
    }
}
