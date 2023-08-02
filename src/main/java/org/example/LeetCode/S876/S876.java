package org.example.LeetCode.S876;

/**
 * 用快慢指针的方法找一个链表的中间元素
 *
 * @author : twave
 * @date : 2023/7/31 13:48
 */
public class S876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        ListNode head1 = new ListNode(arr1);
        ListNode head2 = new ListNode(arr2);
        S876 solution = new S876();
        ListNode res1 = solution.middleNode(head1);
        ListNode res2 = solution.middleNode(head2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
