package org.example.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreamLearning3 {
    /**
     * 终结方法
     * 遍历
     * 统计
     * 收集流中的数据，保存到数组中
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三-11", "李四-25", "王五-30", "赵六-40", "张三丰-100", "张四丰-200", "张五丰-300", "张六丰-400");

        Object[] array = list.stream().toArray();
        System.out.println(Arrays.toString(array));

        String[] strings = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(strings));
    }
}
