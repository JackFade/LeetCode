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
        System.out.println(new L23.Solution().mergeKLists(new ListNode[1]));
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return null;
        }
    }
}


