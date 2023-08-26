package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 无重复元素 的 有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @author : twave
 * @date : 2023/7/14 9:42
 */
public class S228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            // 用StringBuilder代替String，减少内存开销
            // 如果start和end相等，且end等于数组最后一个元素，说明只有一个元素，直接添加到result中
            if (start == end && end == nums.length - 1) {
                result.add(new StringBuilder().append(nums[start]).toString());
                break;
            }
            // 如果end等于数组最后一个元素，且end==数组长度，说明整个数组都是连续的，直接添加到result中
            if (end == nums.length - 1) {
                result.add(new StringBuilder().append(nums[start]).append("->").append(nums[end]).toString());
                break;
            }
            // 如果end+1不等于end+1，说明不连续，添加到result中
            if (nums[end + 1] != nums[end] + 1) {
                // 用占位符构造字符串，添加到result中
                if (start == end) {
                    result.add(new StringBuilder().append(nums[start]).toString());
                } else {
                    result.add(new StringBuilder().append(nums[start]).append("->").append(nums[end]).toString());
                }
                start = end + 1;
            }
            end += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        S228 solution = new S228();
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7, 8, 9}));
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
