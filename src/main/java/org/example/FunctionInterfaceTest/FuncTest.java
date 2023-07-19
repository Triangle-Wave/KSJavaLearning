package org.example.FunctionInterfaceTest;

/**
 * 测试函数式接口
 *
 * @author : twave
 * @date : 2023/7/18 13:28
 */
public class FuncTest {
    public static void main(String[] args) {
        MyTestInterface testInterface = x -> x * 2;
        System.out.println("testInterface.apply(2) = " + testInterface.apply(2));
    }
}
