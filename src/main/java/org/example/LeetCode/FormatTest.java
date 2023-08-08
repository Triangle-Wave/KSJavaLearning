package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入中每行是一对a和b。其中会有一对是0和0标志着输入结束，且这一对不要计算。
 *
 * @author TWAVE
 * @date 2023/8/8 17:45
 */
public class FormatTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> numList = new ArrayList<>();
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            int[] nums = new int[]{a, b};
            numList.add(nums);
        }
        for (int[] nums : numList) {
            System.out.println(nums[0] + nums[1]);
        }
    }
}
