package org.example.LeetCode;

/**
 * @author : TWAVE
 * @date : 2023/5/18 17:34
 */
public class Q221 {
    public static void main(String[] args) {
//        char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
        char[][] matrix = new char[][]{{'0'}, {'0'}, {'1'}};
        SolutionQ221 solutionQ221 = new SolutionQ221();
        System.out.println(solutionQ221.maximalSquare(matrix));
    }
}

class SolutionQ221 {
    public int maximalSquare(char[][] matrix) {
        int x = matrix.length, y = matrix[0].length;
        int min = Math.min(x, y);
        min -= 1;
        if (min == 0) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (matrix[i][j] == '1') {
                        return 1;
                    }
                }
            }
            return 0;
        }

//        System.out.println(max);
        // 定义一个 max*max 大小的卷积核
        for (; min != 0; min--) {
            int step_x = min, step_y = min;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    while (step_x != 0 && step_y != 0) {

                    }
                }
            }

        }
        return 0;
    }
}
