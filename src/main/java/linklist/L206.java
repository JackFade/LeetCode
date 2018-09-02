package linklist;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/
public class L206 {
    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(3);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = null;

        new L206().reverseList(nodeA1).printList();
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = result.next;
            result.next = head;
            head = next;
        }
        return result.next;
    }
}
