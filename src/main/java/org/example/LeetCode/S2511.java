package org.example.LeetCode;


/**
 * @author TWAVE
 * @date 2023/9/2 10:41
 * @finishTime 2023/09/02 11:06:32
 */
public class S2511 {
    public int captureForts(int[] forts) {
        // 判断一个[-1 , ... , 1]或[1 , ... , -1]之间最多有多少个0
        int res = 0;
        int[] stack = new int[2];
        boolean isEmpty = true;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (isEmpty) {
                    isEmpty = false;
                } else {
                    // 如果栈内元素和下一个元素相等，就将栈内元素换为下一个元素
                    if (stack[1] != forts[i]) {
                        res = Math.max(i - stack[0] - 1, res);
                    }
                    // 如果栈内元素和下一个元素不相等，就计算值并和res比较
                }
                stack = new int[]{i, forts[i]};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        S2511 solution = new S2511();
        System.out.println(solution.captureForts(new int[]{1, 1, 1, 0, 0, 1, -1, -1, -1}));
        System.out.println(solution.captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }
}
