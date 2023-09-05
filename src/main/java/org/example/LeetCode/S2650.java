package org.example.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TWAVE
 * @date 2023/9/5 9:10
 * @finishTime 2023/09/05 09:22:49
 */
public class S2650 {
    public int minNumber(int[] nums1, int[] nums2) {
        // 先找两个数组交集的最小值，找不到就分别找两个最小值，组合成最小的整数
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int min1 = Integer.MAX_VALUE;
        for (int i : nums2) {
            if (set.contains(i)) {
                min1 = Math.min(min1, i);
            }
        }
        if (min1 != Integer.MAX_VALUE) {
            return min1;
        }
        int min2 = Integer.MAX_VALUE;
        for (int i : nums1) {
            min1 = Math.min(min1, i);
        }
        for (int i : nums2) {
            min2 = Math.min(min2, i);
        }
        // 找min1和min2中较小的数作为十位数，较大的作为个位数
        return Math.min(min1, min2) * 10 + Math.max(min1, min2);
    }

    public static void main(String[] args) {
        S2650 solution = new S2650();
        System.out.println(solution.minNumber(new int[]{3, 1, 2}, new int[]{1, 2, 3}));
    }
}
