package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/8/11 11:26
 */
public class S1572 {
    public int diagonalSum(int[][] mat) {
        int result = 0, length = mat.length;
        for (int i = 0, start = 0, end = length - 1; i < length; i++, start++, end--) {
            if (start == end) {
                result += mat[i][start];
            } else {
                result += (mat[i][start] + mat[i][end]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S1572 solution = new S1572();
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.diagonalSum(mat));
    }
}
