package org.example.LeetCode.S938;

/**
 * @author TWAVE
 * @date 2023/8/23 10:12
 */
public class S938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        result += rangeSumBST(root.right, low, high);
        result += rangeSumBST(root.left, low, high);
        return result;
    }

    public static void main(String[] args) {
        S938 solution = new S938();
        TreeNode treeNode = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        System.out.println(solution.rangeSumBST(treeNode, 7, 15));
    }
}
