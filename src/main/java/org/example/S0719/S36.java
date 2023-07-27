package org.example.S0719;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合<p>
 * (2)编写方法对List集合进行排序
 * (2)然后利用迭代器遍历集合元素并输出
 * (3)如：15 18 20 40 46 60 65 70 75 91
 *
 * @author : twave
 * @date : 2023/7/19 15:47
 */
public class S36 {
    public static void main(String[] args) {
        // 创建一个List集合
        List<Integer> list = new ArrayList<>();
        // 循环生成10个随机数，存入集合
        for (int i = 0; i < 10; i++) {
            // 生成一个随机数，如果list中存在，就再生成一个，否则加入list
            boolean addFlag = true;
            while (addFlag) {
                int randomNum = (int) ((Math.random() * 100) + 1);
                if (!list.contains(randomNum)) {
                    list.add(randomNum);
                    addFlag = false;
                }
            }
        }
        // 对集合进行排序，覆盖原来的list
        list = list.stream().sorted().collect(Collectors.toList());
        // 用迭代器遍历集合元素并输出
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%s ", iterator.next());
        }
    }
}
