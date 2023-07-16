package org.example.LeetCode;

import java.util.Arrays;

public class S2679 {
    // forEachOrdered方法的功能是对流中的元素进行遍历，与forEach方法不同的是，
    // forEachOrdered方法是按照流中元素的顺序进行遍历的，
    // 而forEach方法则是随机顺序遍历的。
//    public int matrixSum(int[][] nums) {
//        int numRows = nums.length;
//        int numCols = nums[0].length;
//        int[][] newNums = new int[numCols][numRows];
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numCols; j++) {
//                newNums[j][i] = nums[i][j];
//            }
//        }
//        // 对每一行进行排序，从大到小
//        for (int[] row : newNums) {
//            Arrays.sort(row);
//        }
//        for (int[] row : newNums) {
//            System.out.println(Arrays.toString(row));
//        }
//        int result = 0;
//        // 对每一行的第i个元素进行比较，取最大值
//        for (int[] row : newNums) {
//            result += row[numRows - 1];
//        }
//        return result;
//    }
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        for (int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }
        int ans = 0;
        for (int j = 0; j < nums[0].length; ++j) {
            int mx = 0;
            for (int[] row : nums) {
                mx = Math.max(mx, row[j]);
            }
            ans += mx;
        }
        return ans;
    }
    public static void main(String[] args) {
        // 2 3 6 21 555
        int[][] nums = {{3, 9, 5, 8, 1}, {4, 2, 1, 9, 4}, {2, 21, 6, 555, 2}};
        S2679 s2679 = new S2679();
        System.out.println(s2679.matrixSum(nums));
    }
}
