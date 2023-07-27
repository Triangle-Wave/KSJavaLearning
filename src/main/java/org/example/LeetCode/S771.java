package org.example.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : twave
 * @date : 2023/7/24 8:57
 */
public class S771 {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        // 遍历stones，用Map保存每个字母出现的次数，区分大小写
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            // 获取i上的字符，存入map中
            if (map.containsKey(stones.charAt(i))) {
                map.put(stones.charAt(i), map.get(stones.charAt(i)) + 1);
            } else {
                map.put(stones.charAt(i), 1);
            }
        }
        for (int i = 0; i < jewels.length(); i++) {
            if (map.containsKey(jewels.charAt(i))) {
                result += map.get(jewels.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S771 solution = new S771();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    }
}
