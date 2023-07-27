package org.example.S0719;

/**
 * @author : twave
 * @date : 2023/7/19 15:24
 */
public class Apple {
    int num;
    float price;
    Apple apple;

    public Apple() {
        num = 10;
        price = 8.34f;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.num);
    }
}
