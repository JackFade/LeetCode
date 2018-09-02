package linklist;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
*/
public class L86 {
    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(3);
        ListNode nodeA4 = new ListNode(2);
        ListNode nodeA5 = new ListNode(5);
        ListNode nodeA6 = new ListNode(2);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = nodeA6;
        nodeA6.next = null;

        new L86().partition1(nodeA1, 3).printList();
        new L86().partition1(new ListNode(5), 2).printList();
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode cur = head;
        ListNode ltHead = null;
        ListNode ltTail = null;
        ListNode geHead = null;
        ListNode geTail = null;

        while (cur != null) {
            if (cur.val < x) {
                if (ltHead == null) {
                    ltHead = cur;
                } else {
                    ltTail.next = cur;
                }
                ltTail = cur;

            } else {
                if (geHead == null) {
                    geHead = cur;
                } else {
                    geTail.next = cur;
                }
                geTail = cur;
            }

            cur = cur.next;
        }

        if (ltHead == null) {
            return geHead;
        } else if (geHead == null) {
            return ltHead;
        } else {
            ltTail.next = geHead;
        }

        return ltHead;
    }

    public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null){
            return head;
        }

        ListNode ltHead = new ListNode(0);
        ListNode ltTail = ltHead;
        ListNode geHead = new ListNode(0);
        ListNode geTail = geHead;

        while (head != null) {
            if (head.val < x) {
                ltTail.next = head;
                ltTail = head;
            } else {
                geTail.next = head;
                geTail = head;
            }
            head = head.next;
        }
        geTail.next = null;
        ltTail.next = geHead.next;

        return ltHead.next;
    }
}
