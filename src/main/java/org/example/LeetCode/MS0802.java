package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/31 19:37
 */
public class MS0802 {
    int[][] obstacleGrid;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        List<List<Integer>> res = new ArrayList<>();
        boolean sign = dfs(res, 0, 0);
        if (!sign) {
            return new ArrayList<>();
        }
        return res;
    }

    /**
     * DFS算法，用于寻找路径
     *
     * @param path   路径
     * @param row    行
     * @param column 列
     * @return 是否找到路径
     */
    public boolean dfs(List<List<Integer>> path, int row, int column) {
        // 收集当前路径
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(column);
        path.add(list);

        // 递归终止条件，如果越界或者遇到障碍物或者已经走过
        if (row > obstacleGrid.length - 1 || column > obstacleGrid[row].length - 1 || obstacleGrid[row][column] == 1 || obstacleGrid[row][column] == -1) {
            return false;
        }
        // 达到终点，如果是终点则返回true
        if (row == obstacleGrid.length - 1 && column == obstacleGrid[0].length - 1) {
            return true;
        }
        // 先向右递归，如果找到路径则返回true
        if (dfs(path, row, column + 1)) {
            return true;
        }
        // 回溯 移除上次添加的路径
        path.remove(path.size() - 1);
        // 再向下递归，如果找到路径则返回true
        if (dfs(path, row + 1, column)) {
            return true;
        }
        path.remove(path.size() - 1);
        // 如果向右和向下都没有找到路径，则将当前位置标志为已经走过
        obstacleGrid[row][column] = -1;
        return false;
    }

    public static void main(String[] args) {
        MS0802 solution = new MS0802();
        System.out.println(solution.pathWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
