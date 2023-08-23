package org.example.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author TWAVE
 * @date 2023/8/15 8:55
 */
public class S833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(sources[0], indices[0]);
        map.put(sources[1], indices[1]);
        Arrays.sort(indices);
        String result = s;
        int i = s.indexOf(sources[0]);
        if (map.get(sources[0]) == i) {
            result = s.replace(sources[0], targets[0]);
        }
        i = s.indexOf(sources[1]);
        if (map.get(sources[1]) == i) {
            result = result.replace(sources[1], targets[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        S833 solution = new S833();
        System.out.println(solution.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
        System.out.println(solution.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
    }
}
