package org.example.KamaCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author TWAVE
 * @date 2023/8/8 17:56
 */
public class S25 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int cityNum = scanner.nextInt();
        // int lineNum = scanner.nextInt();
        // // 城市数组，初始值全部为-1
        // int[][] cityArray = new int[cityNum][cityNum];
        // for (int[] row : cityArray) {
        //     Arrays.fill(row, -1);
        // }
        // for (int i = 0; i < lineNum; i++) {
        //     int city1 = scanner.nextInt();
        //     int city2 = scanner.nextInt();
        //     int distance = scanner.nextInt();
        //     cityArray[city1 - 1][city2 - 1] = distance;
        //     cityArray[city2 - 1][city1 - 1] = distance;
        // }
        // int startCity = scanner.nextInt();
        // int endCity = scanner.nextInt();
        // for (int k = 0; k < cityNum; k++) {
        //     for (int i = 0; i < cityNum; i++) {
        //         for (int j = 0; j < cityNum; j++) {
        //             if (cityArray[i][k] != -1 && cityArray[k][j] != -1 && (cityArray[i][j] == -1 || cityArray[i][j] > cityArray[i][k] + cityArray[k][j])) {
        //                 cityArray[i][j] = cityArray[i][k] + cityArray[k][j];
        //             }
        //         }
        //     }
        // }
        // System.out.println(cityArray[startCity - 1][endCity - 1] == -1 ? "No path" : cityArray[startCity - 1][endCity - 1]);
        Scanner scanner = new Scanner(System.in);
        int cityNum = scanner.nextInt();
        int lineNum = scanner.nextInt();
        // 城市数组，初始值全部为Integer.MAX_VALUE
        int[][] cityArray = new int[cityNum][cityNum];
        for (int[] row : cityArray) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < lineNum; i++) {
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            int distance = scanner.nextInt();
            cityArray[city1 - 1][city2 - 1] = distance;
            cityArray[city2 - 1][city1 - 1] = distance;
        }
        int startCity = scanner.nextInt();
        int endCity = scanner.nextInt();
        for (int k = 0; k < cityNum; k++) {
            for (int i = 0; i < cityNum; i++) {
                for (int j = 0; j < cityNum; j++) {
                    if (cityArray[i][k] != Integer.MAX_VALUE && cityArray[k][j] != Integer.MAX_VALUE && cityArray[i][j] > cityArray[i][k] + cityArray[k][j]) {
                        cityArray[i][j] = cityArray[i][k] + cityArray[k][j];
                    }
                }
            }
        }
        System.out.println(cityArray[startCity - 1][endCity - 1] == Integer.MAX_VALUE ? "No path" : cityArray[startCity - 1][endCity - 1]);
        for (int[] ints : cityArray) {
            System.out.println(Arrays.toString(ints));
        }
        // System.out.println(startCity + " " + endCity);
        // System.out.println(minDistance);
    }
}
