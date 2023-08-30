package org.example.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author TWAVE
 * @date 2023/8/30 10:30
 */
public class S1823 {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        int index = 0;
        while (linkedList.size() != 1) {
            // 计算当前要删除的位置
            int position = (index + k - 1) % linkedList.size();
            System.out.printf("当前要删除的位置：%s, 当前要删除的元素：%s\n", position, linkedList.get(position));
            linkedList.remove(position);
            index = position;
        }
        return linkedList.getFirst();
    }

    public int findTheWinner2(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        S1823 solution = new S1823();
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
    }
}
