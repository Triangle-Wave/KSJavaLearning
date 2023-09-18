package org.example.LeetCode.S337;

/**
 * @author TWAVE
 * @date 2023/9/18 16:02
 */
public class S337 {
    /**
     * ans[0]表示不偷当前节点的最大值，ans[1]表示偷当前节点的最大值
     *
     * @param root 根节点
     * @return 最大值
     */
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    /**
     * 深度优先算法
     *
     * @param root 节点
     * @return ans[0]表示不偷当前节点的最大值，ans[1]表示偷当前节点的最大值
     */
    private int[] dfs(TreeNode root) {
        // 如果当前节点为空，返回一个长度为2的数组，表示不偷当前节点的最大值为0，偷当前节点的最大值为0
        if (root == null) {
            return new int[2];
        }
        // 当前节点不为空，递归左右子树
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        // 返回一个长度为2的数组
        // 偷当前节点，那么左右子树的节点都不能偷，所以ans[0]=root.val+l[1]+r[1]
        // 不偷当前节点，那么左右子树的节点可以偷，所以ans[1]=Math.max(l[0],l[1])+Math.max(r[0],r[1])
        return new int[]{root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }

    public static void main(String[] args) {
        S337 solution = new S337();
        System.out.println(solution.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
    }
}
