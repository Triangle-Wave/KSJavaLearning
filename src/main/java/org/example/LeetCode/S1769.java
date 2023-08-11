package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/11 16:31
 */
public class S1769 {
    public int[] minOperations(String boxes) {
        if (!boxes.contains("1")) {
            int[] result = new int[boxes.length()];
            for (int i = 0; i < boxes.length(); i++) {
                result[i] = 0;
            }
            return result;
        }
        // 列数
        int length = boxes.length();
        List<int[]> result = new ArrayList<>();
        char[] charArray = boxes.toCharArray();
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '1') {
                int[] line = new int[length];
                boolean add = false;
                for (int j = 0, k = i; j < length; j++) {
                    line[j] = k;
                    if (k == 0) {
                        add = true;
                    }
                    if (add) {
                        k++;
                    } else {
                        k--;
                    }
                }
                result.add(line);
            }
        }
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < length; j++) {
                result.get(result.size() - 1)[j] += result.get(i)[j];
            }
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        S1769 solution = new S1769();
        solution.minOperations("101");
        solution.minOperations("0");
        solution.minOperations("001011");
    }
}
