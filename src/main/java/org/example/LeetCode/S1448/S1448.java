package org.example.LeetCode.S1448;

/**
 * @author TWAVE
 * @date 2023/8/25 9:31
 * @finishTime 2023/08/25 09:43:22
 */
public class S1448 {
    public int goodNodes(TreeNode root) {
        int result = 0;
        result += goodNodes(root, root.val);
        return result;
    }

    public int goodNodes(TreeNode node, int max) {
        int result = 0;
        if (node == null) {
            return result;
        }
        if (node.val >= max) {
            max = node.val;
            result += 1;
        }
        result += goodNodes(node.left, max);
        result += goodNodes(node.right, max);
        return result;
    }

    public static void main(String[] args) {
        S1448 solution = new S1448();
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        System.out.println(solution.goodNodes(treeNode));
    }
}
