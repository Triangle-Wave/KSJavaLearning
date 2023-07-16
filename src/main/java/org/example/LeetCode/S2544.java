package org.example.LeetCode;

import java.util.Stack;

/**
 * @author : twave
 * @date : 2023/7/12 17:03
 */
public class S2544 {
    public int alternateDigitSum(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }
        int result = 0, flag = 1;
        while (!stack.empty()) {
            result += flag * stack.pop();
            flag *= -1;
        }
        return result;
    }

    public int alternateDigitSum2(int n) {
        // 使用Log计算n的位数，需要考虑n为负数的情况
        int length = (int) Math.log10(n) + 1;
        // 使用三目运算符为flag赋值，如果为奇数，flag为1，偶数，flag为-1
        int flag = length % 2 == 0 ? -1 : 1;
        int result = 0;
        while (n != 0) {
            result += flag * (n % 10);
            n /= 10;
            flag *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        S2544 solution = new S2544();
        System.out.println(solution.alternateDigitSum2(123456789));
    }
}
