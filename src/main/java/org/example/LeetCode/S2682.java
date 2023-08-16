package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/16 9:05
 * @finishTime 2023/08/16 09:31:34
 */
public class S2682 {
    public int[] circularGameLosers(int n, int k) {
        int[] result = new int[n];
        result[0] = 1;
        int i = 1, set = 0;
        while (true) {
            set += i * k;
            while (set > n - 1) {
                set = set - n;
            }
            result[set] += 1;
            if (result[set] == 2) {
                break;
            }
            i += 1;
        }
        List<Integer> listResult = new ArrayList<>();
        for (int i1 = 0; i1 < result.length; i1++) {
            if (result[i1] == 0) {
                listResult.add(i1 + 1);
            }
        }
        return listResult.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        S2682 solution = new S2682();
        System.out.println(Arrays.toString(solution.circularGameLosers(5, 2)));
        System.out.println(Arrays.toString(solution.circularGameLosers(4, 4)));
        System.out.println(Arrays.toString(solution.circularGameLosers(2, 1)));
        System.out.println(Arrays.toString(solution.circularGameLosers(3, 2)));
    }
}
