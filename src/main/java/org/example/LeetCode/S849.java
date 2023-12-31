package org.example.LeetCode;


/**
 * @author TWAVE
 * @date 2023/8/22 16:32
 * @finishTime 2023/08/22 17:10:57
 */
public class S849 {
    public int maxDistToClosest(int[] seats) {
        int result = 0,start = 0, end;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 || i == seats.length - 1) {
                end = i;
                if (seats[start] == 0 || seats[end] == 0) {
                    result = Math.max(result, end - start);
                } else {
                    result = Math.max(result, (end - start) / 2);
                }
                start = end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S849 solution = new S849();
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 1}));
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(solution.maxDistToClosest(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}));
        System.out.println(solution.maxDistToClosest(new int[]{0, 1}));
        System.out.println(solution.maxDistToClosest(new int[]{1, 1, 0, 1, 1}));
        System.out.println(solution.maxDistToClosest(new int[]{0, 0, 1, 0, 1, 1}));
    }
}
