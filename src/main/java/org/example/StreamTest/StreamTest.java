package org.example.StreamTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author : twave
 * @date : 2023/7/18 14:27
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 8, 9, 5, 6, 7, 1, 2, 3, null);
        // 用Comparator对list进行排序
        list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(list);
        // 用Stream选出list中的最大值
        System.out.println(list.stream().filter(Objects::nonNull).max(Integer::compareTo).get());
    }
}
