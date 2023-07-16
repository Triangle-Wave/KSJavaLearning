package org.example.Learning;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author TWAVE
 */
public class StreamLearning4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三-男-11", "李四-男-25", "王五-女-30", "赵六-女-40", "张三丰-男-100", "张四丰-男-200", "张五丰-男-300", "张六丰-男-400");

        // Set<String> collect = list.stream()
        //         .filter(s -> "男".equals(s.split("-")[1]))
        //         .filter(s -> Integer.parseInt(s.split("-")[2]) < 100)
        //         .collect(Collectors.toSet());
        Map<String, Integer> collect = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .filter(s -> Integer.parseInt(s.split("-")[2]) < 100)
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(collect);
    }
}
