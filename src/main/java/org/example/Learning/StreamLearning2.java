package org.example.Learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamLearning2 {
    /**
     * 过滤方法
     * 获取前几个元素
     * 跳过前几个元素
     * 元素去重
     * 合并a和b两个流为一个
     * 转换流中的数据类型
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list, "张三", "李四", "王五", "赵六", "张三丰", "张四丰", "张五丰", "张六丰", "张三", "李四", "王五", "赵六");
        Collections.addAll(list2, "张三-11", "李四-25", "王五-30", "赵六-40", "张三丰-100", "张四丰-200", "张五丰-300", "张六丰-400");


        // list.stream()
        //         .distinct()
        //         .forEach(System.out::println);
        //
        // Stream.concat(list.stream(), list2.stream())
        //         .forEach(System.out::println);

        list2.stream()
                .map(s -> Integer.parseInt(s.split("-")[1]))
                .forEach(s -> System.out.println(s));

    }
}
