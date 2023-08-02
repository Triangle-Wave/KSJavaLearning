package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QMerge {
    public static void main(String[] args) {
        SolutionMerge solutionMerge = new SolutionMerge();
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = solutionMerge.merge(input);
        for (int[] ints : output) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}

class SolutionMerge {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.stream(intervals).forEach(list::add);
        return list.toArray(new int[list.size()][2]);
    }
}
