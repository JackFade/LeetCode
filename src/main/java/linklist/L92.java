package linklist;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
*/
public class L92 {
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

        new L92().reverseBetween(nodeA1, 2, 4).printList();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        ListNode betweenHead = result;
        ListNode betweenReverseTail = null;
        for (int i = 1; i <= n; i++) {
            ListNode next = head.next;
            if (i < m) {
                betweenHead.next = head;
            } else {
                head.next = betweenHead.next;
                betweenHead.next = head;
                if (i == m) {
                    betweenReverseTail = head;
                }
                if (i == n) {
                    betweenReverseTail.next = next;
                }
            }
            head = next;
        }
        return result.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;

        for (int i = 0; i < m-1; i++){
            first = first.next;
        }
        ListNode cur = first.next;

        for (int i = 0; i<n-m; i++){
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = first.next;
            first.next = node;

        }

        return dummy.next;
    }
}
