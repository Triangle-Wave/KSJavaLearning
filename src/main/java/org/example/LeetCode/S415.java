package org.example.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）
 * 也不能直接将输入的字符串转换为整数形式
 *
 * @author : twave
 * @date : 2023/7/17 8:50
 */
public class S415 {
    /**
     * 第一种方法采用双端队列实现
     *
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return 相加结果数字字符串
     */
    public String addStrings1(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        // 定义两个双端队列
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        int length = Math.max(num1.length(), num2.length());
        System.out.printf("length: %d\n", length);
        // 将两个字符串中的字符依次入队
        for (int i = 0; i < length; i++) {
            if (i > num1.length() - 1) {
                deque1.offerFirst(0);
            } else {
                deque1.offerLast(num1.charAt(i) - '0');
            }
            if (i > num2.length() - 1) {
                deque2.offerFirst(0);
            } else {
                deque2.offerLast(num2.charAt(i) - '0');
            }
        }

        int carry = 0;
        // 输出两个栈的所有元素
        while (!deque1.isEmpty()) {
            // System.out.printf("long: %d, short: %d, carry: %d\n", deque1.peekFirst(), deque2.peekFirst(), carry);
            int temp = deque1.pollLast() + deque2.pollLast() + carry;
            carry = temp / 10;
            result.append(temp % 10);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    /**
     * 第二种方法采用两个指针实现
     *
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return 相加结果数字字符串
     */
    public String addStrings2(String num1, String num2) {
        // 定义三个StringBuilder
        // result是最终结果
        StringBuilder result = new StringBuilder();
        // sb1是num1的StringBuilder
        StringBuilder sb1 = new StringBuilder(num1);
        // sb2是num2的StringBuilder
        StringBuilder sb2 = new StringBuilder(num2);
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int firstNum, secondNum;
            if (i < 0) {
                firstNum = 0;
            } else {
                firstNum = sb1.charAt(i) - '0';
            }
            if (j < 0) {
                secondNum = 0;
            } else {
                secondNum = sb2.charAt(j) - '0';
            }
            int temp = firstNum + secondNum + carry;
            carry = temp / 10;
            result.append(temp % 10);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        S415 solution = new S415();
        System.out.println(solution.addStrings2("1", "9"));
    }
}
