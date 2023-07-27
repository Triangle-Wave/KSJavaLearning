package org.example.IoTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 测试Try-with-resource语法
 *
 * @author : twave
 * @date : 2023/7/20 16:42
 */
public class TryWithResourceTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.err.println("文件不存在");
        }
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

}
