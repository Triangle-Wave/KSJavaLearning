package org.example.LeetCode.S617;

/**
 * @author TWAVE
 * @date 2023/8/14 9:29
 */
public class S617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return root2;
        }
        if (root2 == null && root1 != null) {
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }


    public static void main(String[] args) {
        S617 solution = new S617();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode result = solution.mergeTrees(treeNode1, treeNode2);
    }
}
