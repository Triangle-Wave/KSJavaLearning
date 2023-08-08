package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/7 9:03
 */
public class S344 {
    public void reverseString(char[] s) {
        char temp;
        String s1 = new String(s);
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        S344 solution = new S344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o', 'n'};
        solution.reverseString(s);
        System.out.println(s);
    }
}
