package divideAndConquer;

import java.util.List;

/*
*
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0]
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.

* */
public class L315 {
    public static void main(String[] args) {
        System.out.println(new L315.Solution().countSmaller(new int[]{4,5,6,7,0,1,2}));
    }

    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            return null;
        }
    }
}


