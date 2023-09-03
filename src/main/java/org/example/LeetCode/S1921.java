package org.example.LeetCode;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author TWAVE
 * @date 2023/9/3 9:12
 */
public class S1921 {
    public int eliminateMaximum2(int[] dist, int[] speed) {
        int length = dist.length;
        // 先消灭一个距离减速度最小的怪物，被消灭的怪物dist置为-1
        int index = 0, res = 0;
        for (int i = 0; i < length; i++) {
            if (dist[i] - speed[i] < dist[index] - speed[index]) {
                index = i;
            }
        }
        dist[index] = -1;
        res += 1;
        boolean findMin = true;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                if (dist[j] != -1) {
                    if (findMin) {
                        index = j;
                        findMin = false;
                    }
                    dist[j] = Math.max(dist[j] - speed[j], 0);
                    if (dist[j] == 0) {
                        return res;
                    }
                    if (dist[j] - speed[j] < dist[index] - speed[index]) {
                        index = j;
                    }
                }
            }
            // 找到距离最近的怪物，消灭掉
            dist[index] = -1;
            res += 1;
            findMin = true;
        }
        return res;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int length = dist.length;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            pq.offer((double) dist[i] / speed[i]);
        }
        System.out.println(pq);
        int res = 0, time = 0;
        while (!pq.isEmpty()) {
            if (pq.poll() <= time) {
                return res;
            }
            res++;
            time++;
        }
        return res;
    }

    public static void main(String[] args) {
        S1921 solution = new S1921();
        System.out.println(solution.eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));          // 3
        System.out.println(solution.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));    // 1
        System.out.println(solution.eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));          // 1
        System.out.println(solution.eliminateMaximum(new int[]{4, 2}, new int[]{5, 1}));          // 2
        System.out.println(solution.eliminateMaximum(new int[]{4, 3, 4}, new int[]{1, 1, 2}));          // 3
        System.out.println(solution.eliminateMaximum(
                new int[]{46, 33, 44, 42, 46, 36, 7, 36, 31, 47, 38, 42, 43, 48, 48, 25, 28, 44, 49, 47, 29, 32, 30, 6, 42, 9, 39, 48, 22, 26, 50, 34, 40, 22, 10, 45, 7, 43, 24, 18, 40, 44, 17, 39, 36},
                new int[]{1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 3, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 8, 1, 1, 1, 3, 6, 1, 3, 1, 1}));          // 3
    }
}
