package org.example.KamaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author TWAVE
 * @date 2023/8/12 10:58
 */
public class S6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int all = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < all; i++) {
            int size = scanner.nextInt();
            int[] temp = new int[size];
            for (int j = 0; j < size; j++) {
                temp[j] = scanner.nextInt();
            }
            list.add(temp);
        }
        for (int i = 0; i < list.size(); i++) {
            int result = 0;
            for (int j = 0; j < list.get(i).length; j++) {
                result += list.get(i)[j];
            }
            System.out.printf(String.valueOf(result));
            if (i != list.size() - 1) {
                System.out.println("\n");
            }
        }
    }
}
