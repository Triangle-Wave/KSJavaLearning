package org.example.LeetCode;

public class Q1419 {
    public static void main(String[] args) {
        Solution1419 solution = new Solution1419();
//        System.out.println(solution.minNumberOfFrogs("croakcroak"));
        System.out.println(solution.minNumberOfFrogs("crocracokrakoak"));
    }
}

class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // 创建一个长度为 5 的计数器数组，用于跟踪每个字符出现的次数
        int frogs = 0, maxFrogs = 0; // 初始化青蛙数量和最大青蛙数量
        for (char c : croakOfFrogs.toCharArray()) { // 遍历字符串中的每个字符
            int index = "croak".indexOf(c); // 获取当前字符在 "croak" 中的索引
            if (index == -1) { // 如果索引为 -1，说明字符串中包含无效字符
                return -1; // 返回 -1
            }
            count[index]++; // 增加当前字符的计数器
            if (index == 0) { // 如果当前字符为 'c'
                maxFrogs = Math.max(maxFrogs, ++frogs); // 增加青蛙数量并更新最大青蛙数量
            } else if (--count[index - 1] < 0) { // 如果当前字符不是 'c'，则检查前一个字符的计数器是否小于 0
                return -1; // 如果小于 0，则返回 -1
            } else if (index == 4) { // 如果当前字符为 'k'
                --frogs; // 减少青蛙数量
            }
        }
        return frogs == 0 ? maxFrogs : -1; // 如果最终青蛙数量为 0，则返回最大青蛙数量，否则返回 -1
    }
}
