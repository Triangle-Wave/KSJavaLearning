package org.example.Learning;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author TWAVE
 * @date 2023/6/9 14:02
 */
public class createNumbers {
    public static void main(String[] args) {
        // createFile();
        String filePath = "E:\\Projects\\JavaProjects\\Java_study\\file.txt";
        findMax20(filePath);
    }

    private static void findMax20(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // 读取文件内容
            String line = reader.readLine();

            // 将读取的内容按空格分割为字符串数组
            String[] numbersArray = line.split(" ");

            // 将字符串数组转换为整数列表
            // 第一步：使用Arrays.stream() 将字符串数组转换为流
            // 第二步：使用mapToInt() 将字符串转换为整数
            // 第三步：使用toList() 将流转换为列表
            List<Integer> numbersList =
                    Arrays.stream(numbersArray)
                            .map(Integer::parseInt)
                            .sorted(Collections.reverseOrder())
                            .collect(Collectors.toList());
            // 对列表进行降序排序
            // 打印最大的前 20 个数字
            for (int i = 0; i < 20 && i < numbersList.size(); i++) {
                System.out.println(numbersList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            int randomNum = random.nextInt();
            stringBuilder.append(randomNum).append(" ");
        }
        String path = "file.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
