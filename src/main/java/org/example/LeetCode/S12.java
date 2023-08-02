/*
 * @Author: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @Date: 2022-11-01 15:19:44
 * @LastEditors: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @LastEditTime: 2023-04-14 10:09:24
 * @FilePath: \Java_study\src\Questions\S12.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package org.example.LeetCode;

public class S12 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.intToRoman(60));
    }
}

class Solution12 {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            int digit = (int) (num / Math.pow(10, i) % 10);
            if (i == 3 && digit != 0) {
                // 操作千位数
                for (int j = 0; j < digit; j++) {
                    result.append("M");
                }
            } else if (i == 2 && digit != 0) {
                // 操作百位数
                if (digit < 4) {
                    // 1-3
                    for (int j = 0; j < digit; j++) {
                        result.append("C");
                    }
                } else if (digit == 4) {
                    // 4
                    result.append("CD");
                } else if (digit == 5) {
                    // 5
                    result.append("D");
                } else if (digit < 9) {
                    // 5-8
                    result.append("D");
                    for (int j = 0; j < digit - 5; j++) {
                        result.append("C");
                    }
                } else {
                    // 9
                    result.append("CM");
                }
            } else if (i == 1 && digit != 0) {
                // 操作十位数
                if (digit < 4) {
                    // 1-3
                    for (int j = 0; j < digit; j++) {
                        result.append("X");
                    }
                } else if (digit == 4) {
                    // 4
                    result.append("XL");
                } else if (digit == 5) {
                    // 5
                    result.append("L");
                } else if (digit < 9) {
                    // 5-8
                    result.append("L");
                    for (int j = 0; j < digit - 5; j++) {
                        result.append("X");
                    }
                } else {
                    // 9
                    result.append("XC");
                }
            } else if (i == 0 && digit != 0) {
                // 操作个位数
                if (digit < 4) {
                    // 1-3
                    for (int j = 0; j < digit; j++) {
                        result.append("I");
                    }
                } else if (digit == 4) {
                    // 4
                    result.append("IV");
                } else if (digit == 5) {
                    // 5
                    result.append("V");
                } else if (digit < 9) {
                    // 5-8
                    result.append("V");
                    for (int j = 0; j < digit - 5; j++) {
                        result.append("I");
                    }
                } else {
                    // 9
                    result.append("IX");
                }
            }
        }
        return result.toString();
    }
}

class Solution_2 {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                result.append(romans[i]);
                num -= nums[i];
            }
        }
        return result.toString();
    }
}
