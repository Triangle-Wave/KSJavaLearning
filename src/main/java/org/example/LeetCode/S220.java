package org.example.LeetCode;

import java.util.TreeSet;

/**
 * @author TWAVE
 * @date 2023/8/29 19:58
 */
public class S220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= valueDiff) {
                return true;
            }
            if (r != null && r - u <= valueDiff) {
                return true;
            }
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= indexDiff) {
                ts.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S220 solution = new S220();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2, 5, 9, 1, 5, 9}, 4, 0));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2, 2}, 2, 0));
    }
}
