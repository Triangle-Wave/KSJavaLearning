package org.example.LeetCode;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

/**
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * <p>
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * <p>
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 *
 * @author TWAVE
 * @date 2023/9/12 10:06
 */
public class S1462 {
    /**
     * 有向图的传递闭包
     *
     * @param n             有向图的节点数
     * @param prerequisites 有向图的边
     * @param queries       查询的边
     * @return 查询的边是否在有向图中
     */
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // 传递闭包
        boolean[][] f = new boolean[n][n];
        // 初始化传递闭包
        for (var p : prerequisites) {
            f[p[0]][p[1]] = true;
        }
        // 计算传递闭包
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 如果i到k有边，k到j有边，则i到j有边
                    // 将 f[i][j] 的值与 f[i][k] && f[k][j] 的值进行 “或” 运算，可以得到 f[i][j] 的最终值
                    f[i][j] |= f[i][k] && f[k][j];
                }
            }
        }
        // 构建答案
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(f[q[0]][q[1]]);
        }
        return ans;
    }

    public static void main(String[] args) {
        S1462 solution = new S1462();
        System.out.println(solution.checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}));
    }
}
