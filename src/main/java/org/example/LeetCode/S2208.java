package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : twave
 * @date : 2023/7/25 13:13
 */
public class S2208 {
    public int halveArray(int[] nums) {
        int result = 0, length = nums.length - 1;
        float midResult = 0;
        float sum = (float) Arrays.stream(nums).sum() / 2;
        List<Float> list = new ArrayList<>();
        for (int num : nums) {
            list.add((float) num);
        }
        System.out.printf("sum: %s ", sum);
        Collections.sort(list);
        while (true) {
            float max = list.remove(length) / 2;
            System.out.printf("操作数为：%s ", max);
            midResult += max;
            result++;
            if (midResult >= sum) {
                System.out.printf("midResult: %s ", midResult);
                return result;
            }
            list.add(max);
            Collections.sort(list);
        }
    }

    public static void main(String[] args) {
        S2208 solution = new S2208();
        System.out.println(solution.halveArray(new int[]{1, 2, 10, 8, 5}));
        System.out.println(solution.halveArray(new int[]{5, 19, 8, 1}));
        System.out.println(solution.halveArray(new int[]{3, 8, 20}));
        System.out.println(solution.halveArray(new int[]{32, 98, 23, 14, 67, 40, 26, 9, 96, 96, 91, 76, 4, 40, 42, 2, 31, 13, 16, 37, 62, 2, 27, 25, 100, 94, 14, 3, 48, 56, 64, 59, 33, 10, 74, 47, 73, 72, 89, 69, 15, 79, 22, 18, 53, 62, 20, 9, 76, 64}));
    }
}
