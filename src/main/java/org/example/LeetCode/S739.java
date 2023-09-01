package org.example.LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author TWAVE
 * @date 2023/9/1 9:42
 */
public class S739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < length; i++) {
            // 如果后一个数字大于前一个数字
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getFirst()]) {
                res[stack.getFirst()] = i - stack.getFirst();
                stack.poll();
            }
            stack.addFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        S739 solution = new S739();
        // System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        // System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 40, 50, 60})));
        // System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})));
    }
}
