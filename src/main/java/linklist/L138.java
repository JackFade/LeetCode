package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwanglong on 2018/8/25.
 */

/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深度拷贝。
*/
public class L138 {
    public static void main(String[] args) {
        RandomListNode nodeA1 = new RandomListNode(1);
        RandomListNode nodeA2 = new RandomListNode(2);
        RandomListNode nodeA3 = new RandomListNode(3);
        RandomListNode nodeA4 = new RandomListNode(4);
        RandomListNode nodeA5 = new RandomListNode(5);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = null;
        nodeA1.random = nodeA3;
        nodeA2.random = nodeA4;
        nodeA3.random = nodeA3;
        nodeA4.random = null;
        nodeA5.random = nodeA4;

        new L138().copyRandomList(nodeA1);
    }

    private RandomListNode copyRandomList1(RandomListNode head) {

        if(head == null) {
            return null;
        }

        Map<RandomListNode, Integer> nodeIndexMap = new HashMap<RandomListNode, Integer>();
        Map<Integer, RandomListNode> newIndexNodeMap = new HashMap<Integer, RandomListNode>();

        RandomListNode newHead = new RandomListNode(0);
        int i = 0;

        for (RandomListNode cur = head, newPre = newHead; cur != null; cur = cur.next, newPre = newPre.next, i++) {
            nodeIndexMap.put(cur, i);
            RandomListNode newNode = new RandomListNode(cur.label);
            newPre.next = newNode;
            newIndexNodeMap.put(i, newNode);
        }

        for (RandomListNode cur = head, newNode = newHead.next; cur != null; cur = cur.next, newNode = newNode.next) {
            Integer index = nodeIndexMap.get(cur.random);
            newNode.random = newIndexNodeMap.get(index);
        }

        return newHead.next;
    }

    private RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode cur = head;

        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }


        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode tmp;
        while (cur != null) {
            tmp = cur.next.next;
            if (tmp != null) {
                cur.next.next = tmp.next;
            }
            cur.next = tmp;
            cur = cur.next;
        }

        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        return "" + label;
    }
}
