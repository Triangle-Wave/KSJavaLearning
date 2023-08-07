package org.example.LeetCode.S24;

/**
 * @author TWAVE
 * @date 2023/8/6 9:37
 */
public class S24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        // 保存上一轮的尾节点
        while ((head != null && head.next != null)) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = head.next;
            if (head != null && head.next != null) {
                temp.next.next = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S24 solution = new S24();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = solution.swapPairs(listNode);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
