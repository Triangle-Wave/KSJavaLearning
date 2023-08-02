package org.example.Learning;

/**
 * @author TWAVE
 * @date 2023/8/2 19:19
 */
public class StringTest {
    public static void main(String[] args) {
        // String s1 = "test";
        // String s2 = "test";
        // String s3 = new String("test") + "my";
        String s1 = "abc";
        String s2 = new String("def");
        String s3 = s1 + s2;
        String s4 = "abcdef";
        System.out.println(s3 == s4); // false
    }
}
