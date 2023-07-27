package org.example.S0719;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author : twave
 * @date : 2023/7/19 15:43
 */
public class TestConvert {
    public static void main(String[] args) throws IOException {
        // 准备一个字符串
        String contents = " 上海金仕达软件科技股份有限公司";
        System.out.println(contents);
        // 请转化为字节数组并输出
        byte[] bytes = contents.getBytes();
        System.out.println(Arrays.toString(bytes));
        // 请将字节数组转化为字符串并输出
        String str = new String(bytes);
        System.out.println(str);
    }
}
