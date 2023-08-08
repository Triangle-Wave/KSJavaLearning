package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/8/8 13:10
 */
public class S1749 {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }

    public static void main(String[] args) {
        S1749 solution = new S1749();
        int[] nums = new int[]{1, -3, 2, 3, 5};
        System.out.println(solution.maxAbsoluteSum(nums));
    }
}
