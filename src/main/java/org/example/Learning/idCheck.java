package org.example.Learning;

import java.util.Scanner;

/**
 * @author : TWAVE
 * @date : 2023/5/18 15:58
 */
public class idCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入身份证号: ");
        String idNumber = scanner.nextLine();
        if (idNumber.length() == 18 && idNumber.matches("[0-9]+")) {
            System.out.println("正确");
        } else {
            System.err.println("错误");
        }
    }
}
