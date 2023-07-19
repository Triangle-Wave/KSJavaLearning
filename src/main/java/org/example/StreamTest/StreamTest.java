package org.example.StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author : twave
 * @date : 2023/7/18 14:27
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, null);
        // 用Comparator选出list中的最大值
        System.out.println(list.stream().filter(Objects::nonNull).max(Integer::compareTo).get());
    }
}
