package org.example.KamaCode;

import java.util.*;

/**
 * @author TWAVE
 * @date 2023/8/12 18:12
 */
public class S7 {
    public static void main(String[] args) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        scoreMap.put('A', 4);
        scoreMap.put('B', 3);
        scoreMap.put('C', 2);
        scoreMap.put('D', 1);
        scoreMap.put('F', 0);
        while (scanner.hasNext()) {
            String sentence = scanner.nextLine();
            boolean soutResult = true;
            char[] input = sentence.replaceAll(" ", "").toCharArray();
            float sum = 0;
            for (char c : input) {
                if (!scoreMap.containsKey(c)) {
                    System.out.println("Unknown");
                    soutResult = false;
                    break;
                } else {
                    sum += scoreMap.get(c);
                }
            }
            if (soutResult) {
                System.out.printf("%.2f%n", sum / input.length);
            }
        }
    }
}
