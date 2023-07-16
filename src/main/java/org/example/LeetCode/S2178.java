package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class S2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        // 几个2的问题
        if (finalSum % 2 != 0) {
            return null;
        }
        List<Long> result = new ArrayList<>();
        // 这些2如何组合
        long numOf2 = finalSum / 2;
        // 将numOf2这个整数拆成不重复的数的集合的方法
        for (int i = 1; i <= numOf2; i++) {
            if (numOf2 - i > i) {
                result.add((long) i * 2);
                numOf2 -= i;
            } else {
                result.add(numOf2 * 2);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S2178 s2178 = new S2178();
        System.out.println(s2178.maximumEvenSplit(54));
    }
}
