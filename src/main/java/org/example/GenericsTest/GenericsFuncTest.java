package org.example.GenericsTest;

/**
 * 测试泛型方法
 *
 * @author : twave
 * @date : 2023/7/20 16:47
 */
public class GenericsFuncTest {
    /**
     * 泛型方法 printArray <p>
     * 用于输出集合中的元素 <p>
     * 该方法接受一个泛型数组，该泛型数组可以是任何类型，然后遍历数组中的元素并输出
     *
     * @param inputArray 泛型数组
     * @param <E>        泛型
     */
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 初始化一个字符串数组
        String[] strArray = {"Java", "C++", "Python", "Go"};
        // 初始化一个Integer数组
        Integer[] intArray = {1, 2, 3, 4, 5};
        // 调用泛型方法
        printArray(strArray);
        printArray(intArray);
    }
}
