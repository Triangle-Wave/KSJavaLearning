package org.example.LeetCode.S21;


/**
 * @author TWAVE
 * @date 2023/8/5 15:57
 */
public class S21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return result.next;

        // ListNode prehead = new ListNode(-1);
        // ListNode prev = prehead;
        // while (list1 != null && list2 != null) {
        //     if (list1.val <= list2.val) {
        //         prev.next = list1;
        //         list1 = list1.next;
        //     } else {
        //         prev.next = list2;
        //         list2 = list2.next;
        //     }
        //     prev = prev.next;
        // }
        // // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        // prev.next = list1 == null ? list2 : list1;
        // return prehead.next;
    }

    public static void main(String[] args) {
        S21 solution = new S21();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node = solution.mergeTwoLists(list1, list2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
