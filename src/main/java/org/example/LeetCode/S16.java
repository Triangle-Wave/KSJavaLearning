package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author : twave
 * @date : 2023/7/10 10:24
 */
public class S16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        // 将target添加进nums中
        int[] newNums = new int[nums.length + 1];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        newNums[nums.length] = target;
        newNums = Arrays.stream(newNums).sorted().toArray();
        int location = 0;
        // 找到target在newNums中的位置
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] == target) {
                location = i;
                break;
            }
        }
        System.out.println("location" + location);
        // 将原数组分成左右两块，左边小于target，右边大于target
        // 用两个指针分别指向target左边和右边的元素
        return 0;
    }

    public static void main(String[] args) {
        S16 solution = new S16();
        System.out.println(solution.threeSumClosest(new int[]{1, 2, 1, -2}, 1));
    }
}
