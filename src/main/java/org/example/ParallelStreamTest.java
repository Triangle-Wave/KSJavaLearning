package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * 测试并行流
 *
 * @author : twave
 * @date : 2023/7/19 9:23
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        int sumOfSquares = list.parallelStream()
                .map(x -> x * x)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sumOfSquares);
    }
}
