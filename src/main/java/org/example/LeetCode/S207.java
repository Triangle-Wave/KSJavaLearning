package org.example.LeetCode;

import java.util.*;

/**
 * @author TWAVE
 * @date 2023/9/9 9:23
 */
public class S207 {
    /**
     * 判断有向图是否成环
     *
     * @param numCourses    有向图的节点数
     * @param prerequisites 有向图的边
     * @return 是否成环，成环返回false，不成环返回true
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断是否成环
        int[][] graph = new int[numCourses][numCourses];
        for (int[] ints : prerequisites) {
            graph[ints[0]][ints[1]] = 1;
        }
        // 深度优先遍历判断是否成环
        // 访问数组，0表示未访问，1表示正在访问，2表示已经访问
        int[] visit = new int[numCourses];
        // 遍历所有节点
        boolean result = true;
        for (int i = 0; i < numCourses; i++) {
            // 如果当前节点未被访问，且当前节点成环，返回true
            if (visit[i] == 0 && dfs(graph, visit, i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 深度优先遍历判断是否成环
     *
     * @param graph 外接矩阵
     * @param visit 访问数组，0表示未访问，1表示正在访问，2表示已经访问
     * @param i     当前访问的节点
     * @return 是否成环，成环返回true，不成环返回false
     */
    private boolean dfs(int[][] graph, int[] visit, int i) {
        // 访问当前节点，设置为1，表示正在访问
        visit[i] = 1;
        // 遍历当前节点的所有邻接节点
        for (int w = 0; w < graph[i].length; w++) {
            // 如果graph[i][w]为1，表示i和w之间有边
            if (graph[i][w] == 1) {
                // 如果有边且w正在被访问，说明成环
                if (visit[w] == 1) {
                    return true;
                }
                // 如果有边且w未被访问，递归访问w
                if (visit[w] == 0 && dfs(graph, visit, w)) {
                    return true;
                }
            }
        }
        // 访问完当前节点，设置为2，表示已经访问
        visit[i] = 2;
        // 返回false，表示当前节点没有成环
        return false;
    }

    public static void main(String[] args) {
        S207 solution = new S207();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(solution.canFinish(5, new int[][]{{0, 2}, {2, 4}, {2, 1}, {4, 1}, {3, 2}}));
    }
}
