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
public class T142 {
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
        nodeA8.next = nodeA5;
        nodeA1.printList();
        new T142().detectCycle(nodeA1).printList();
    }

    public ListNode detectCycle(ListNode head) {
        return null;
    }
}
