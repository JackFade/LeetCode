package divideAndConquer;

import linklist.ListNode;

/*
*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

* */
public class L23 {
    public static void main(String[] args) {

        ListNode listA = new ListNode(-1);
        ListNode listB = new ListNode(-2);
        ListNode listC = new ListNode(-1);
        ListNode listD = new ListNode(-5);

        ListNode curA = listA;
        ListNode curB = listB;
        ListNode curC = listC;
        ListNode curD = listD;
        for (int i = 0; i < 3; i++) {
            curA.next = new ListNode(i);
            curA = curA.next;
            curB.next = new ListNode(i*2);
            curB = curB.next;
            curC.next = new ListNode(i*3);
            curC = curC.next;
            curD.next = new ListNode(i*4);
            curD = curD.next;
        }

        listA.printList();
        listB.printList();
        listC.printList();
        listD.printList();

        new L23.Solution().mergeKLists(new ListNode[]{listA, listB, listC, listD}).printList();
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }

            int start = 0;
            int end = lists.length - 1;

            return mergeKLists(lists, start, end);
        }

        private ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (end == start) {
                return lists[end];
            }


            ListNode combinedRoot = new ListNode(0);
            ListNode comCur = combinedRoot;
            ListNode left = mergeKLists(lists, start, (start+end) / 2);
            ListNode right = mergeKLists(lists, (start+end) / 2 + 1, end);
            while (left != null || right != null) {
                if (right == null || (left != null && left.val < right.val)) {
                    comCur.next = left;
                    left = left.next;
                } else {
                    comCur.next = right;
                    right = right.next;
                }
                comCur = comCur.next;

            }
            return combinedRoot.next;
        }
    }
}


