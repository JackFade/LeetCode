package linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
编写一个程序，找到两个单链表相交的起始节点。



例如，下面的两个链表：

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
在节点 c1 开始相交。



注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
*/
public class L160 {
    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeC1 = new ListNode(3);
        ListNode nodeC2 = new ListNode(4);
        ListNode nodeC3 = new ListNode(5);
        ListNode nodeB1 = new ListNode(0);
        ListNode nodeB2 = new ListNode(1);
        ListNode nodeB3 = new ListNode(2);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeC1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeC1;
        nodeC1.next = nodeC2;
        nodeC2.next = nodeC3;
        nodeC3.next = null;
        nodeA1.printList();
        nodeB1.printList();
        new L160().getIntersectionNode2(nodeA1, nodeB1).printList();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        for (ListNode cur = headA; cur != null; cur = cur.next) {
            nodeSet.add(cur);
        }

        for (ListNode cur = headB; cur != null; cur = cur.next) {
            if (nodeSet.contains(cur)) {
                return cur;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        for (ListNode curA = headA; curA != null; curA = curA.next) {
            aLength ++;
        }
        for (ListNode curB = headB; curB != null; curB = curB.next) {
            bLength ++;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                curA = curA.next;
            }
        } else if (aLength < bLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
