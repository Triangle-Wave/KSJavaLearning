package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/8/24 14:43
 */
public class S1267 {
    public int countServers(int[][] grid) {
        int result = 0;
        int length = grid[0].length, height = grid.length;
        int[][] dp = new int[height][length];
        for (int i = 0; i < height; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                for (int j = 0; j < length; j++) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < height; j++) {
                if (grid[j][i] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                for (int j = 0; j < height; j++) {
                    if (grid[j][i] == 1) {
                        dp[j][i] = 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for (int[] ints : dp) {
            result += Arrays.stream(ints).sum();
        }
        return result;
    }

    public static void main(String[] args) {
        S1267 solution = new S1267();
        System.out.println(solution.countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(solution.countServers(new int[][]{{1, 0, 1}, {1, 0, 1}}));
        System.out.println(solution.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }
}
