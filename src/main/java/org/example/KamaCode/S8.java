package org.example.KamaCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author TWAVE
 * @date 2023/8/12 18:51
 */
public class S8 {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int num = scanner.nextInt();
    //     // scanner.nextLine();
    //     while (scanner.hasNext()) {
    //         if (scanner.nextInt() == 0) {
    //             break;
    //         }
    //         int[] line = new int[num];
    //         int sum = 0;
    //         for (int i = 0; i < num; i++) {
    //             line[i] = scanner.nextInt();
    //             sum += line[i];
    //         }
    //         int temp = sum / num;
    //         int result = 0;
    //         for (int i = 0; i < num; i++) {
    //             line[i] = line[i] - temp;
    //             if (line[i] > 0) {
    //                 result += line[i];
    //             }
    //         }
    //         System.out.println(result);
    //     }
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Integer size = scanner.nextInt();
            if (size == 0) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            Integer sum = 0;
            for (int i = 0; i < size; i++) {
                int num = scanner.nextInt();
                sum += num;
                list.add(num);
            }
            Integer average = sum / size;
            Integer res = 0;
            //由于题目中说明了保证积木总数能被积木堆数整除，那么肯定能够把多出来的转到少的积木堆上面的
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > average) {
                    res += list.get(i) - average;
                }
            }
            System.out.println(res);
            System.out.println();
        }
    }
}
