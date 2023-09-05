/*
 * @Author: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @Date: 2023-04-14 10:12:12
 * @LastEditors: 于洋 10096490+yuyang-t@user.noreply.gitee.com
 * @LastEditTime: 2023-04-14 10:46:27
 * @FilePath: \Java_study\src\study\generics.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package org.example.Learning;

import org.example.FieldTest.Student;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Java泛型的学习
 */
public class generics_study {
    public static void main(String[] args) {
        Combine<String> stringCombine = new Combine<>();
        String resultString = stringCombine.combine("Hello", "World");
        System.out.println(resultString);
        Combine<Double> doubleCombine = new Combine<Double>();
        Double resultDouble = doubleCombine.combine(3.14, 6.28);
        System.out.println(resultDouble);
        Combine<Object[]> arrayCombine = new Combine<>();
        Object[] resultObject = arrayCombine.combine(new Object[] { 1, 2 }, new Object[] { "t", "1" });
        System.out.println(resultObject);
        List<Student> list = new ArrayList<>();
    }
}

class Combine<T> {
    public T combine(T a, T b) {
        if (a instanceof String && b instanceof String) {
            // 都是字符串的情况下
            // 将结果转换为类型T
            return (T) (((String) a) + ((String) b));
        } else if (a instanceof Number && b instanceof Number) {
            // 都是数字的情况下
            return (T) (Double.valueOf(((Number) a).doubleValue() + ((Number) b).doubleValue()));
        } else if (a instanceof Object[] && b instanceof Object[]) {
            Object[] arrayA = (Object[]) a;
            Object[] arrayB = (Object[]) b;
            Object[] result = new Object[arrayA.length + arrayB.length];
            System.arraycopy(arrayA, 0, result, 0, arrayA.length);
            System.arraycopy(arrayB, 0, result, arrayA.length, arrayB.length);
            return (T) result;
        } else {
            throw new IllegalArgumentException("Unsupported types");
        }
    }
}