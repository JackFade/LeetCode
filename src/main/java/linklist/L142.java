package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

说明：不允许修改给定的链表。
*/
public class L142 {
    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(3);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);
        ListNode nodeA6 = new ListNode(6);
        ListNode nodeA7 = new ListNode(7);
        ListNode nodeA8 = new ListNode(8);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = nodeA6;
        nodeA6.next = nodeA7;
        nodeA7.next = nodeA8;
        nodeA8.next = nodeA4;
        nodeA1.printList();
        new L142().detectCycle1(nodeA1).printList();
        new L142().detectCycle2(nodeA1).printList();
        new L142().detectCycle2(new ListNode(8)).printList();
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (nodeSet.contains(cur)) {
                return cur;
            } else {
                nodeSet.add(cur);
            }
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slower = head;
        ListNode faster = head;


        while (slower != null && faster != null) {
            slower = slower.next;
            faster = faster.next;

            if (faster == null || faster.next == null) {
                // 无环的情况
                return null;
            } else {
                faster = faster.next;
            }

            if (faster == slower) {
                break;
            }
        }

        faster = head;
        while (faster != slower) {
            faster = faster.next;
            slower = slower.next;
        }
        return faster;
    }
}
