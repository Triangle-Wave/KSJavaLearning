package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author TWAVE
 */

public class subsequence {
    public static void main(String[] args) {
        String str = "abcde";
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < str.length(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                // 将当前字符添加到之前的子序列中
                // charAt的功能是返回字符串指定索引处的字符
                // result.get()的功能是返回指定位置的元素
                result.add(result.get(j) + str.charAt(i));
            }
        }
        // Collections库是Java集合框架的成员，提供了一系列静态方法，能更方便地操作各种集合
        // Collections.sort的功能是对result进行排序，按照字典序
        Collections.sort(result);
        System.out.println(result);
    }
}
