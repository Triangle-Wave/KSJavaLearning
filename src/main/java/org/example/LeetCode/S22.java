package org.example.LeetCode;

import java.util.*;

/**
 * @author TWAVE
 * @date 2023/8/11 13:23
 */
public class S22 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("()");
        result.add(temp);
        for (int i = 1; i < n; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < result.get(i - 1).size(); j++) {
                temp.add("(" + result.get(i - 1).get(j) + ")");
                temp.add(result.get(i - 1).get(j) + "()");
                temp.add("()" + result.get(i - 1).get(j));
            }
            Set<String> hashSet = new HashSet<>(temp);
            List<String> newResult = new ArrayList<>(hashSet);
            result.add(newResult);
        }
        System.out.println(result.get(n - 1));
        return result.get(n - 1);
    }

    public static void main(String[] args) {
        S22 solution = new S22();
        // solution.generateParenthesis(1);
        // solution.generateParenthesis(2);
        // solution.generateParenthesis(3);
        List<String> list1 = solution.generateParenthesis(4);
        // solution.generateParenthesis(5);

        List<String> list = new ArrayList<>(Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
        list.removeAll(list1);
        System.out.println(list);
    }
}
