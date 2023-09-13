package org.example.LeetCode;

import java.util.HashMap;

/**
 * 骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * <p>
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * <p>
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 *
 * @author TWAVE
 * @date 2023/9/13 9:35
 */
public class S2596 {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int[] position = map.get(0);
        for (int i = 1; i < length * length; i++) {
            int[] temp = map.get(i);
            if ((Math.abs(temp[0] - position[0]) == 1 && Math.abs(temp[1] - position[1]) == 2) ||
                    (Math.abs(temp[0] - position[0]) == 2 && Math.abs(temp[1] - position[1]) == 1)) {
                position = temp;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S2596 solution = new S2596();
        System.out.println(solution.checkValidGrid(new int[][]{
                {0, 5, 18, 9, 12, 27},
                {3, 8, 1, 28, 19, 10},
                {6, 17, 4, 11, 26, 13},
                {33, 2, 7, 22, 29, 20},
                {16, 23, 34, 31, 14, 25},
                {35, 32, 15, 24, 21, 30}
        }));
        System.out.println(solution.checkValidGrid(new int[][]{
                {24, 11, 22, 17, 4},
                {21, 16, 5, 12, 9},
                {6, 23, 10, 3, 18},
                {15, 20, 1, 8, 13},
                {0, 7, 14, 19, 2}}
        ));
    }
}
