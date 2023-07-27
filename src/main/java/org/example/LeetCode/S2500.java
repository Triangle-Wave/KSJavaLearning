package org.example.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : twave
 * @date : 2023/7/27 8:46
 */
public class S2500 {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0, max = 0;
        Arrays.stream(grid).forEach(Arrays::sort);
        // 找每一列的最大值
        for (int j = 0; j < grid[0].length; j++) {
            for (int[] ints : grid) {
                max = Math.max(ints[j], max);
            }
            result += max;
        }
        return result;
    }

    public static void main(String[] args) {
        S2500 solution = new S2500();
        Scanner scanner = new Scanner(System.in);
        // 获取二维数组的行数
        int n = scanner.nextInt();
        int[][] grid = new int[n][];
        // 获取每一行的元素，按空格分割
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays
                    .stream(scanner.next().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // 打印测试用例

        System.out.println(solution.deleteGreatestValue(grid));
    }
}
