package org.example.LeetCode.S143;

/**
 * @author : twave
 * @date : 2023/7/31 13:58
 */
public class S143 {
    public void reorderList(ListNode head) {
        // 用快慢指针找到链表的中间节点
        // 如果链表是偶数个节点，则找到第二个中间节点
        if (head.next != null) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow即为中间节点
            // 双指针反转slow以后的链表
            ListNode cur = null;
            ListNode pre = slow.next;
            slow.next = null;
            while (pre != null) {
                ListNode t = pre.next;
                pre.next = cur;
                cur = pre;
                pre = t;
            }
            ListNode result = head;
            while (result != null && cur != null) {
                ListNode temp1 = result.next;
                ListNode temp2 = cur.next;

                result.next = cur;
                cur.next = temp1;

                result = temp1;
                cur = temp2;
            }
        }
    }

    public static void main(String[] args) {
        S143 solution = new S143();
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        ListNode head1 = new ListNode(arr1);
        ListNode head2 = new ListNode(arr2);
        solution.reorderList(head1);
        solution.reorderList(head2);
    }
}
