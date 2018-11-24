package divideAndConquer;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(new L315.Solution().countSmaller(new int[]{1,1}));
    }

    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            if(nums.length == 1) {
                List<Integer> count = new ArrayList<>(1);
                count.add(0);
                return count;
            }

            Integer[] countArray = new Integer[nums.length];
            Arrays.fill(countArray, 0);
            List<Integer> count = Arrays.asList(countArray);
            Pair<Integer, Integer> [] pairs = new Pair[nums.length];
            for (int i = 0; i < nums.length; i++) {
                pairs[i] = new Pair<>(i, nums[i]);
            }

            pairCount(0, nums.length - 1, pairs, count);
            return count;
        }

        private void pairCount(int start, int end, Pair<Integer, Integer>[] pairs, List<Integer> count) {
            if (start < end) {
                int mid = (start + end) / 2;
                pairCount(start, mid, pairs, count);
                pairCount(mid + 1, end, pairs, count);
                mergePairs(start, mid, end, pairs, count);
            }
        }

        private void mergePairs(int start, int mid, int end, Pair<Integer, Integer>[] pairs, List<Integer> count) {
            Pair<Integer, Integer>[] tmpPairs = new Pair[end - start + 1];
            int aIndex = start;
            int bIndex = mid + 1;
            int i = 0;
            while (aIndex <= mid && bIndex <= end) {
                if (pairs[aIndex].getValue() <= pairs[bIndex].getValue()) {
                    tmpPairs[i++] = pairs[aIndex];
                    count.set(pairs[aIndex].getKey(), count.get(pairs[aIndex].getKey()) +  (bIndex - mid -1));
                    aIndex++;
                } else if (pairs[aIndex].getValue() >= pairs[bIndex].getValue()) {
                    tmpPairs[i++] = pairs[bIndex++];
                }
            }

            while (aIndex <= mid) {
                tmpPairs[i++] = pairs[aIndex];
                count.set(pairs[aIndex].getKey(), count.get(pairs[aIndex].getKey()) +  (bIndex - mid -1));
                aIndex++;
            }

            while (bIndex <= end) {
                tmpPairs[i++] = pairs[bIndex++];
            }

            for (int j = 0; j < tmpPairs.length; j++) {
                pairs[start+j] = tmpPairs[j];
            }
        }
    }
}


