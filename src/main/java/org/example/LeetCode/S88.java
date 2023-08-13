package org.example.LeetCode;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n
 * <p>
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @author TWAVE
 * @date 2023/8/13 10:36
 */
public class S88 {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     if (n >= 0) {
    //         System.arraycopy(nums2, 0, nums1, m, m + n - m);
    //     }
    //     Arrays.sort(nums1);
    // }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i - 1] = nums1[m - 1];
                i--;
                m--;
            } else {
                nums1[i - 1] = nums2[n - 1];
                i--;
                n--;
            }
        }
    }

    public static void main(String[] args) {
        S88 solution = new S88();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
