package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TWAVE
 * @date 2023/9/14 9:31
 */
public class S1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        boolean[][] isQueen = new boolean[8][8];
        for (int[] q : queens) {
            isQueen[q[0]][q[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] d : directions) {
            int x = king[0] + d[0];
            int y = king[1] + d[1];
            while (0 <= x && x < 8 && 0 <= y && y < 8) {
                if (isQueen[x][y]) {
                    ans.add(Arrays.asList(x, y));
                    break;
                }
                x += d[0];
                y += d[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        S1222 solution = new S1222();
        System.out.println(solution.queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
    }
}
