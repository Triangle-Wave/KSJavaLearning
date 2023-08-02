package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Q1023 {
    public static void main(String[] args) {
        Solution1023 solution = new Solution1023();
        String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
        String pattern = "FB";
        System.out.println(solution.camelMatch(queries, pattern));
    }
}

class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        return result;
    }
}