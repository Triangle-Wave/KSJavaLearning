package org.example.LeetCode;

import java.util.Arrays;

/**
 * 面试题1611
 *
 * @author : twave
 * @date : 2023/7/13 8:42
 */
public class MS1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] result = new int[k + 1];
        if (k == 0) {
            return new int[]{};
        }
        // 如果长短板的长度一致，则直接返回结果，不需要去重
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        // 如果不一致，则数组中的每个元素都不一致，也不需要去重
        for (int i = 0; i <= k; i++) {
            result[i] = (shorter * (k - i) + longer * i);
        }
        // 数组去重
        // result = Arrays.stream(result).distinct().toArray();
        return result;
    }

    public static void main(String[] args) {
        MS1611 solution = new MS1611();
        System.out.println(Arrays.toString(solution.divingBoard(1, 1, 10000)));
    }
}
