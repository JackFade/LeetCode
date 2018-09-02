package linklist;

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
        RandomListNode nodeA2 = new RandomListNode(4);
        RandomListNode nodeA3 = new RandomListNode(3);
        RandomListNode nodeA4 = new RandomListNode(2);
        RandomListNode nodeA5 = new RandomListNode(5);
        RandomListNode nodeA6 = new RandomListNode(2);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = nodeA6;
        nodeA6.next = null;

        new L138().copyRandomList(nodeA1);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        return null;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
