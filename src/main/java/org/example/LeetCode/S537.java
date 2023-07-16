package org.example.LeetCode;

import java.util.Arrays;

/**
 * 两个字符串表示的复数 num1 和 num2
 * 请你遵循复数表示形式，返回表示它们乘积的字符
 *
 * @author TWAVE
 * @date 2023/7/16 15:33
 */
public class S537 {
    public String complexNumberMultiply(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        String[] num1s = num1.split("\\+");
        String[] num2s = num2.split("\\+");
        // System.out.printf("num1s = %s, num1s = %s\n", Arrays.toString(num1s), Arrays.toString(num2s));
        // nums[0]是实部，nums[1]是虚部
        // 计算方法是：(a+bi)*(c+di) = ac+adi+bci+bdi^2 = (ac-bd)+(ad+bc)i
        // a是num1s[0]
        int a = Integer.parseInt(num1s[0]);
        // b是num1s[1]的前半部分，也就是去掉最后一个字符i
        int b = Integer.parseInt(num1s[1].substring(0, num1s[1].length() - 1));
        // c是num2s[0]
        int c = Integer.parseInt(num2s[0]);
        // d是num2s[1]的前半部分，也就是去掉最后一个字符i
        int d = Integer.parseInt(num2s[1].substring(0, num2s[1].length() - 1));
        result.append(a * c - b * d).append('+').append(a * d + b * c).append('i');
        return result.toString();
    }

    public static void main(String[] args) {
        S537 solution = new S537();
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
