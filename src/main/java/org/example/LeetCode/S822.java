package org.example.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
 * <p>
 * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
 * <p>
 * 如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
 * <p>
 * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
 * <p>
 * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
 * <p>
 * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
 *
 * @author TWAVE
 * @date 2023/8/2 18:16
 */
public class S822 {
    public int flipGame(int[] fronts, int[] backs) {
        int result = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
                continue;
            }
            set2.add(fronts[i]);
            set2.add(backs[i]);
        }
        System.out.println(set2);
        for (Integer integer : set2) {
            if (!set.contains(integer)) {
                result = Math.min(result, integer);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        S822 solution = new S822();
        System.out.println(solution.flipGame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
        System.out.println(solution.flipGame(new int[]{1}, new int[]{1}));
        System.out.println(solution.flipGame(new int[]{1, 1}, new int[]{2, 2}));
    }
}
