package org.example.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TWAVE
 * @date 2023/8/30 9:57
 * @finishTime 2023/08/30 10:16:45
 */
public class S2244 {
    public int minimumRounds(int[] tasks) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            while (true) {
                // 先用3匹配，再用2匹配
                if (value == 1) {
                    return -1;
                }
                if (value - 3 == 0 || value - 2 == 0) {
                    result += 1;
                    break;
                } else if (value - 3 > 1) {
                    value -= 3;
                    result += 1;
                } else if (value - 2 > 1) {
                    value -= 2;
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S2244 solution = new S2244();
        System.out.println(solution.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));


    }
}
