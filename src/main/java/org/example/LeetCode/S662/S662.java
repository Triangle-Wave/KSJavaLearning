package org.example.LeetCode.S662;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author TWAVE
 * @date 2023/8/5 16:57
 */
public class S662 {
    public int widthOfBinaryTree(TreeNode root) {
        ExecutorService service = Executors.newCachedThreadPool();
        if (root == null) {
            return 0;
        }
        // Pair<TreeNode Integer> 用于记录节点和节点的位置
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        // 先把根节点入队
        queue.offer(new Pair<>(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            // 左节点的位置是当前层的第一个节点的位置
            int left = queue.peek().getValue();
            // 开始时右节点位置和左节点位置一致
            int right = left;
            for (int i = 0; i < queue.size(); i++) {
                // 取出Pair
                Pair<TreeNode, Integer> pair = queue.poll();
                // 取出节点
                TreeNode node = pair.getKey();
                right = pair.getValue();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, right * 2));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, right * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
