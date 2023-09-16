package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/9/15 15:23
 */
public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] operation : operations) {
            int value = gem[operation[0]] / 2;
            gem[operation[0]] -= value;
            gem[operation[1]] += value;
        }
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println(Arrays.toString(gem));
        return max - min;
    }

    public static void main(String[] args) {
        LCP50 solution = new LCP50();
        System.out.println(solution.giveGem(new int[]{1, 2, 3, 4, 5, 6}, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(solution.giveGem(new int[]{100, 0, 50, 100}, new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}}));
    }
}
