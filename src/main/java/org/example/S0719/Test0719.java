package org.example.S0719;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author : twave
 * @date : 2023/7/19 15:15
 */
public class Test0719 {
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Test test = new Test();
        // Thread thread = new Thread(test);
        // thread.res;
        OutputStream f=new FileOutputStream(new File("F:\\MyProjects\\Test\\test.txt"));
// A
    }
//     public static void main(String[] args) {
//         /*
//         如果一个list初始化为{5，3，1}，执行以下代码后，其结果为（）？
// nums.add(6);
// nums.add(0,4);
// nums.remove(1);*
// [4, 3, 1, 6]
// [5, 3, 1, 6]
// [4, 3, 6]
// [5, 3, 6]
//          */
//         List<Integer> list = new ArrayList<>();
//         list.add(5);
//         list.add(3);
//         list.add(1);
//         list.add(6);
//         list.add(0, 4);
//         list.remove(1);
//         System.out.println(list);
//         List<String> list = Arrays.asList("dddd", "ee", "qqq", "bcfff");
//         Optional<String> result = list.stream().findFirst();
//         System.out.println(result.get());
//         Thread.sleep();
//
//     }
}
