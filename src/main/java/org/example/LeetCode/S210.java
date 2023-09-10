package org.example.LeetCode;

import java.util.*;

public class S210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 定义一个空数组
        int[] result = new int[numCourses];
        // 计算每个节点的入度，用数组保存节点的入度
        int[] inDegree = new int[numCourses];
        for (int[] ints : prerequisites) {
            inDegree[ints[0]]++;
        }
        // 用队列保存入度为0的节点，后续节点直接添加到队列尾部
        Deque<Integer> queue = new ArrayDeque<>();
        // 将入度为0的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                // 入度为0的节点加入队列
                queue.addLast(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            // 出队列
            int i = queue.removeFirst();
            // 将出队列的节点加入结果集
            result[index++] = i;
            // 遍历出队列节点的邻接节点
            for (int[] ints : prerequisites) {
                if (ints[1] == i) {
                    // 将邻接节点的入度减1
                    inDegree[ints[0]]--;
                    // 如果邻接节点的入度为0，加入队列
                    if (inDegree[ints[0]] == 0) {
                        queue.addLast(ints[0]);
                    }
                }
            }
        }
        // 如果结果集的大小等于节点数，说明没有环
        return index == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        S210 solution = new S210();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
