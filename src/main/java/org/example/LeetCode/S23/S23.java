package org.example.LeetCode.S23;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author TWAVE
 * @date 2023/8/12 10:23
 */
public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 构建一个优先队列（堆），堆顶元素为最小值，排序规则为节点值的大小
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // 虚拟头节点
        ListNode dummy = new ListNode(0), cur = dummy;
        // 初始化堆
        for (ListNode head : lists) {
            // 如果链表不为空，加入堆中
            if (head != null) {
                pq.add(head);
            }
        }
        // 如果堆不为空，取出堆顶元素，加入到结果链表中，如果堆顶元素有下一个节点，将下一个节点加入堆中
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            if (poll.next != null) {
                pq.add(poll.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 有序合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        S23 solution = new S23();
    }
}
