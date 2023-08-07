package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/6 10:12
 */
public class S2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            System.out.println(word);
            // 如果是特殊字符，需要转义
            String[] split = word.split(String.valueOf("\\" + separator));
            System.out.println(Arrays.toString(split));
            for (String s : split) {
                if (s != null && s.length() > 0) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S2788 solution = new S2788();
        List<String> words = new ArrayList<>(Arrays.asList("one.two.three", "four.five", "six"));
        System.out.println(solution.splitWordsBySeparator(words, '.'));
    }
}
