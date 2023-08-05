package org.example.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/8/5 16:27
 */
public class S648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(dictionary);
        List<String> sentences = Arrays.asList(sentence.split(" "));
        StringBuffer result = new StringBuffer();
        for (String s : sentences) {
            boolean appendFlag = true;
            for (String d : dictionary) {
                if (s.startsWith(d)) {
                    result.append(d);
                    result.append(" ");
                    appendFlag = false;
                    break;
                }
            }
            if (appendFlag) {
                result.append(s);
                result.append(" ");
            }
        }
        System.out.println(sentences);
        return result.toString().trim();
    }

    public static void main(String[] args) {
        S648 solution = new S648();
        System.out.println(solution.replaceWords(Arrays.asList("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
