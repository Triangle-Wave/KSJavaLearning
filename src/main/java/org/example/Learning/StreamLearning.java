package org.example.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author TWAVE
 */
public class StreamLearning {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("张三丰");
        list.add("张司丰");
        list.add("张五丰");
        ArrayList<String> list2 = new ArrayList<>();
        // stream中的filter是过滤器，可以对集合中的元素进行过滤
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 2)
                .forEach(name -> list2.add(name));
        list2.stream()
                .forEach(System.out::println);

        ArrayList<String> list3 = new ArrayList<>();
        // Collections是集合工具类，主要用于对集合进行操作
        // addAll方法可以将一个集合中的元素全部添加到另一个集合中
        Collections.addAll(list3, "a", "b", "c", "d", "e");
        list3.stream().filter(s -> "a".equals(s)).forEach(s -> System.out.println(s));

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("张三", 18);
        hashMap.put("李四", 19);
        hashMap.put("王五", 20);
        hashMap.put("赵六", 21);
        // 使用keySet方法获取hashMap中的所有key，然后使用stream方法获取流
        hashMap.keySet().stream().forEach(s -> System.out.println(hashMap.get(s)));
        hashMap.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));

        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(s -> System.out.println(s));

        Integer[] arr2 = {1, 2, 3, 4, 5};
        // Stream.of方法可以将一组数据转换为流
        // 需要包装类型而不是基本类型
        Stream.of(1, 2, 3, 4, 5).forEach(s -> System.out.println(s));
        Stream.of("a", "b", "c", "d", "e").forEach(s -> System.out.println(s));
        Stream.of(arr2).forEach(s -> System.out.println(s));
    }
}
