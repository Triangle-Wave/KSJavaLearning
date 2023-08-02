package org.example.LeetCode;

/**
 * @author TWAVE
 * 1、dp[i]代表的是到达i位置所需的花费
 * 2、递推公式：dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
 * 要多算一步dp[i-1]和dp[i-2]的变化
 * dp[i-2] = dp[i-1];   dp[i-1] = dp[i];
 * 3、初始化dp，基础是dp[0]和dp[1]
 * 4、遍历顺序，从前向后
 */
public class Q746 {
    public static void main(String[] args) {
        SolutionQ746 solution = new SolutionQ746();
        int[] cost = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}

class SolutionQ746 {
    public int minCostClimbingStairs(int[] cost) {
        int p = 0, q = 0, r = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            r = Math.min(p + cost[i - 1], q + cost[i - 2]);
            q = p;
            p = r;
        }
        return r;
    }
}