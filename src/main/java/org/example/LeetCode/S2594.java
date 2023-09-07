package org.example.LeetCode;

import java.util.Arrays;

/**
 * @author TWAVE
 * @date 2023/9/7 9:55
 */
public class S2594 {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long min = 0L, max = (long) ranks[0] * cars * cars;
        // 对min和max用二分法进行查找
        while (max > min) {
            System.out.printf("min=%d, max=%d\n", min, max);
            long mid = (min + max) / 2;
            long sum = 0L;
            for (int rank : ranks) {
                sum += Math.sqrt((double) mid / rank);
            }
            System.out.printf("sum=%d, cars=%d\n", sum, cars);
            if (sum >= cars) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        S2594 solution = new S2594();
        System.out.println(solution.repairCars(new int[]{5, 1, 8}, 6));
        // System.out.println(solution.repairCars(new int[]{3, 5, 2, 4, 1}, 3));
        // System.out.println(solution.repairCars(new int[]{3, 5, 2, 4, 1}, 10));
    }
}
