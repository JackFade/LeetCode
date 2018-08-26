package linklist;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/
public class T21 {

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = null;

        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = null;

        new T21().mergeTwoLists(nodeA1, nodeB1).printList();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultTail = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                resultTail.next = l1;
                l1 = l1.next;
            } else {
                resultTail.next = l2;
                l2 = l2.next;
            }

            resultTail = resultTail.next;
        }

        if (l1 != null) {
            resultTail.next = l1;
        }
        if (l2 != null) {
            resultTail.next = l2;
        }
        return result.next;
    }
}


