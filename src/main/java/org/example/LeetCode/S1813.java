package org.example.LeetCode;

/**
 * @author : twave
 * @date : 2023/7/7 8:34
 */
public class S1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        // 从前往后比较，如果相同则i++，直到不相同
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        // 从后往前比较，如果相同则j++，直到不相同
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == words1.length || i + j == words2.length;
    }

    public static void main(String[] args) {
        S1813 solution = new S1813();
        System.out.println(solution.areSentencesSimilar("My name is Haley", "My Haley is"));
    }
}
