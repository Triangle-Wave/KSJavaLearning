package org.example.LeetCode;

/**
 * @author TWAVE
 */
public class Q1991 {
    public static void main(String[] args) {
        Q1991 q1991 = new Q1991();
        int[] array = new int[]{2, 3, -1, 8, 4};
        System.out.println(q1991.pivotIndex(array));
    }

    public int pivotIndex(int[] nums) {
        int sums = 0, sumsHead = 0, numsLength = nums.length;
        if (numsLength == 1) {
            return 0;
        }
        for (int num : nums) {
            sums += num;
        }
        for (int i = 0; i < numsLength; i++) {
            if (sums - nums[i] - sumsHead == sumsHead) {
                return i;
            }
            if (i == numsLength - 1 && sumsHead == 0) {
                return numsLength - 1;
            }
            sumsHead += nums[i];
        }
        return -1;
    }
}

