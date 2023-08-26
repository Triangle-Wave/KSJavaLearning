package org.example.LeetCode.S104;

/**
 * @author TWAVE
 * @date 2023/8/26 15:15
 */
public class S104 {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        result += 1;
        result += Math.max(maxDepth(root.left), maxDepth(root.right));
        return result;
    }

    public static void main(String[] args) {
        S104 solution = new S104();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.maxDepth(treeNode));
    }
}
