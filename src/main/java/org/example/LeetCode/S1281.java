package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/8/9 12:35
 */
public class S1281 {
    public int subtractProductAndSum(int n) {
        String[] nums = String.valueOf(n).split("");
        int sum = 0, product = 1;
        for (String num : nums) {
            sum += Integer.parseInt(num);
            product *= Integer.parseInt(num);
        }
        return product - sum;
    }

    public static void main(String[] args) {
        S1281 solution = new S1281();
        System.out.println(solution.subtractProductAndSum(234));
        System.out.println(solution.subtractProductAndSum(4421));
    }
}
