/*
 * @Author: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @Date: 2023-04-17 14:40:08
 * @LastEditors: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @LastEditTime: 2023-04-17 14:40:11
 * @FilePath: \Java_study\src\study\binToDec.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package org.example.Learning;

public class binToDec {
    public static void main(String[] args) {
        System.out.println(binaryToDecimal("10110100"));
    }

    public static int binaryToDecimal(String binaryString) {
        int decimal = 0;
        int n = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, n);
            }
            n++;
        }
        return decimal;
    }
}
