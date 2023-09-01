package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/9/1 9:09
 */
public class S2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0L;
        // 最多买n支笔1
        int n = total / cost1;
        for (int i = 0; i <= n; i++) {
            // 买了i支笔1，剩下的钱可以买j支笔2
            int j = (total - (cost1 * i)) / cost2;
            System.out.printf("买了%d支笔1，剩下的钱可以买%d支笔2\n", i, j);
            res += j + 1;
        }
        // System.out.println(n);
        return res;
    }

    public static void main(String[] args) {
        S2240 solution = new S2240();
        System.out.println(solution.waysToBuyPensPencils(20, 10, 5));
        System.out.println(solution.waysToBuyPensPencils(5, 10, 10));
        System.out.println(solution.waysToBuyPensPencils(5, 3, 2));
    }
}
