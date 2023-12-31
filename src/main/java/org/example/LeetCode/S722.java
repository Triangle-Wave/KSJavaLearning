package org.example.LeetCode;

import java.util.*;

/**
 * @author TWAVE
 * @date 2023/8/3 10:43
 */
public class S722 {


    public List<String> removeComments(String[] source) {
        String joinedSource = String.join("\n", source);
        // 这段正则分为两部分
        // //.*用于匹配单行注释
        // /\*(.|\n)*?\*/用于匹配多行注释，以/*开头，匹配任意数量的任意字符，包含换行符，直到遇到/*结束
        String withoutComments = joinedSource.replaceAll("//.*|/\\*(.|\\n)*?\\*/", "");
        List<String> result = new ArrayList<>(Arrays.asList(withoutComments.split("\n")));
        result.removeIf(String::isEmpty);
        return result;
    }

    public static void main(String[] args) {
        S722 solution = new S722();
        System.out.println(solution.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
    }
}
