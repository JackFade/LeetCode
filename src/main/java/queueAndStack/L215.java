package queueAndStack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
* */
public class L215 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{2,1}, 1));
    }
}

class Solution {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (queue.peek() < nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
