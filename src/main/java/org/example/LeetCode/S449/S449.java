package org.example.LeetCode.S449;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author TWAVE
 * @date 2023/9/4 9:37
 */
public class S449 {
    /**
     * 二叉搜索树的序列化
     *
     * @param root 根节点
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        // 构建一个列表，存储节点值
        List<Integer> list = new ArrayList<>();
        // 将二叉搜索树后序遍历，存储到列表中
        postOrder(root, list);
        // 将列表转为字符串
        String str = list.toString();
        // 去除字符串两端的中括号
        return str.substring(1, str.length() - 1);
    }

    /**
     * 二叉搜索树的反序列化
     *
     * @param data 序列化后的字符串
     * @return 根节点
     */
    public TreeNode deserialize(String data) {
        // 如果字符串为空，直接返回null
        if (data.isEmpty()) {
            return null;
        }
        // 将字符串转为数组
        String[] arr = data.split(", ");
        // 构建一个栈，存储节点值
        Deque<Integer> stack = new ArrayDeque<>();
        // 将数组中的元素存储到栈中
        for (String s : arr) {
            stack.push(Integer.parseInt(s));
        }
        // 构建二叉搜索树
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     * @param list 存储节点值的列表
     */
    private void postOrder(TreeNode root, List<Integer> list) {
        // 递归结束条件，如果节点为空，直接返回
        if (root == null) {
            return;
        }
        // 后序遍历左子树
        postOrder(root.left, list);
        // 后序遍历右子树
        postOrder(root.right, list);
        // 将节点值存储到列表中
        list.add(root.val);
    }

    /**
     * 构造二叉搜索树
     *
     * @param lower 最小值
     * @param upper 最大值
     * @param stack 存储节点值的栈
     * @return 根节点
     */
    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        // 如果栈为空，或者栈顶元素不在区间范围内，直接返回null
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        // 取出栈顶元素
        int val = stack.pop();
        // 构建根节点
        TreeNode root = new TreeNode(val);
        // 构建右子树
        root.right = construct(val, upper, stack);
        // 构建左子树
        root.left = construct(lower, val, stack);
        // 返回根节点
        return root;
    }


    public static void main(String[] args) {
        S449 solution = new S449();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String serialize = solution.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println(deserialize);
    }
}
