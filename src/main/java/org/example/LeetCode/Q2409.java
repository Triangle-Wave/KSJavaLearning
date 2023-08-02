package org.example.LeetCode;

import java.util.ArrayList;

public class Q2409 {
    public static void main(String[] args) {
        Solution_Q2409 s = new Solution_Q2409();
        System.out.println(s.countDaysTogether("08-06", "12-08", "02-04", "09-01"));
        // s.countDaysTogether("05-01", "06-10", "07-10", "08-09");
    }
}

class Solution_Q2409 {
    private static final int[] month_list = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 创建一个int数组，保存每个月的天数
        String[] date_list = { arriveAlice, leaveAlice, arriveBob, leaveBob };
        ArrayList<Integer> days = new ArrayList<Integer>(4);
        int day = 0;
        for (String date : date_list) {
            day = 0;
            String[] parts = date.split("-");
            for (int month = 0; month < Integer.parseInt(parts[0]) - 1; month++) {
                day += month_list[month];
            }
            day += Integer.parseInt(parts[1]);
            days.add(day);
        }
        if (days.get(1) < days.get(2) || days.get(3) < days.get(0)) {
            return 0;
        } else {
            return Math.min(days.get(1), days.get(3)) - Math.max(days.get(0), days.get(2)) + 1;
        }
    }
}