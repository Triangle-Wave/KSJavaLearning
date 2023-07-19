package org.example.FunctionInterfaceTest;

/**
 * 一个函数式接口，只有一个抽象方法
 * 用于测试函数式接口
 *
 * @author : twave
 * @date : 2023/7/18 13:25
 */
@FunctionalInterface
public interface MyTestInterface {
    int apply(int x);
}
