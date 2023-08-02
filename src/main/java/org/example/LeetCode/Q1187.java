package org.example.LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1187 {
    public static void main(String[] args) {
        SolutionQ1187 solution = new SolutionQ1187();
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 2, 4};
        System.out.println(solution.makeArrayIncreasing(arr1, arr2));
    }
}

class SolutionQ1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // flag_last用于保存当前操作数的上一个数
        // num_func用于保存操作次数
        int flag_last = 0, numFunc = 0;
        // 将arr2改为动态数组
        List<Integer> list = IntStream.of(arr2).boxed().collect(Collectors.toList());
        ArrayList<Integer> dynamicArray = new ArrayList<>(list);
        for (int i = 0; i < arr1.length; i++) {
//            // 第0个数时先为flag_last赋值
//            if (i == 0) {
//                flag_last = arr1[i];
//            } else {
//                if (arr1[i] > flag_last) {
//                    // 从第二个数开始，第一种情况，严格递增
//                    flag_last = arr1[i];
//                } else {
//                    // 第二种情况，不满足严格递增
//                    // 2.1 从arr2中找一个大于flag_last的数
//                    for (int j = 0; j < dynamicArray.size(); j++) {
//                        if (dynamicArray.get(j) > flag_last && dynamicArray.get(j) <= arr1[i]) {
//                            // 赋值
//                            arr1[i-1] = arr2[j];
//                            // 操作数+1
//                            numFunc += 1;
//                            // 从arr2中删除arr2[j]
//                            dynamicArray.remove(j);
//                            break;
//                        }
//                    }
//                    // 如果找不到，返回-1
//                    if (arr1[i] <= flag_last) {
//                        return -1;
//                    }
//                }
//            }

        }
        return numFunc;
    }
}