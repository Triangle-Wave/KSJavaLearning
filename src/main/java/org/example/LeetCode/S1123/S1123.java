package org.example.LeetCode.S1123;

import java.util.List;

/**
 * @author TWAVE
 * @date 2023/9/6 9:28
 */
public class S1123 {
    int maxLength = 0;
    TreeNode result = null;

    /**
     * 1123. 最深叶节点的最近公共祖先
     *
     * @param root 根节点
     * @return 最深叶节点的最近公共祖先
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    /**
     * 深度优先搜索，递归
     *
     * @param root  根节点
     * @param depth 深度
     * @return 最大深度
     */
    public int dfs(TreeNode root, int depth) {
        // 如果节点为空，返回-1
        if (root == null) return -1;
        // 节点不为空，递归返回左右子树的最大深度
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        // 更新最大深度，与当前深度比较
        maxLength = Math.max(depth, maxLength);
        // 如果当前节点的深度等于最大深度，更新结果
        if (depth == maxLength) result = root;
        // 如果左右子树的最大深度都等于最大深度，更新结果
        if (left == right && left == maxLength) result = root;
        // 返回当前节点左右子树的最大深度
        return Math.max(left, Math.max(right, depth));
    }


    public static void main(String[] args) {
        S1123 solution = new S1123();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode treeNode = solution.lcaDeepestLeaves(root);
        System.out.println(treeNode.val);
    }
}
