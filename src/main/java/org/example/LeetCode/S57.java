package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/28 9:27
 */
public class S57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> resList = new ArrayList<>();
        // 从左边开始找不重合的
        int left = 0;
        // 从右边开始找不重合的
        int right = intervals.length - 1;

        // 找到左边不重合的位置，将左边不重合的添加到list中
        while (left < intervals.length && intervals[left][1] < newInterval[0]) {
            resList.add(intervals[left]);
            left += 1;
        }

        // 找到右边不重合的位置，将右边不重合的添加到list中
        while (right >= 0 && intervals[right][0] > newInterval[1]) {
            resList.add(left, intervals[right]);
            right -= 1;
        }

        // 合并中间重合的区间
        int[] newArr = new int[2];
        // 这里要注意，如果left大于intervals.length，说明newInterval[0]比所有区间都大，所以newArr[0]就是newInterval[0]
        // 否则就是intervals[left][0]和newInterval[0]的最小值
        newArr[0] = left >= intervals.length ? newInterval[0] : Math.min(intervals[left][0], newInterval[0]);
        // 如果right小于0，说明newInterval[1]比所有区间都小，所以newArr[1]就是newInterval[1]
        // 否则就是intervals[right][1]和newInterval[1]的最大值
        newArr[1] = right < 0 ? newInterval[1] : Math.max(intervals[right][1], newInterval[1]);
        resList.add(left, newArr);

        // 这一大坨是把list转二维数组
        int[][] resArr = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        S57 solution = new S57();

        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 5}}, new int[]{0, 0})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}
