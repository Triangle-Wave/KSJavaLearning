package org.example.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses，
 * <p>
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * <p>
 * 返回你最多可以修读的课程数目。
 *
 * @author TWAVE
 * @date 2023/9/11 9:37
 */

public class S630 {
    /**
     * 使用大根堆进行计算
     *
     * @param courses 所有课程的二维数组
     * @return 最多可修课程数
     */
    public int scheduleCourse(int[][] courses) {
        // 以结束时间排序
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);
        // 储存已选择的课程，按照持续时间排序
        PriorityQueue<int[]> heap = new PriorityQueue<>((c1, c2) -> c2[0] - c1[0]);
        int day = 0;
        for (int[] c : courses) {
            if (day + c[0] <= c[1]) {
                // 如果当前课程时间不冲突，将该课程加入队列
                // 这里的不冲突可以理解为，0~day+c[0]这段区间，我们还可以再插入当前一节课
                day += c[0];
                heap.offer(c);
            } else if (!heap.isEmpty() && heap.peek()[0] > c[0]) {
                // 课程时间冲突，且有选过其他课，这时我们找到最长时间的课程，用当前的短课替换了，余出了更多的空区间
                // 所以这里我们余出的时间其实就是两者的持续时间之差，课程变短了，day会前移，这样我们相当于变相给后面的课程增加了选择的区间
                day -= heap.poll()[0] - c[0];
            }
        }
        System.out.println(heap);
        return heap.size();
    }

    public static void main(String[] args) {
        S630 solution = new S630();
        System.out.println(solution.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(solution.scheduleCourse(new int[][]{
                {5, 5},
                {4, 6},
                {2, 6}
        }));
        System.out.println(solution.scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}));
    }
}
