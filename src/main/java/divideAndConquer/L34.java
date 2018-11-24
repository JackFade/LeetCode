package divideAndConquer;

import java.util.Arrays;

/*
*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

* */
public class L34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1},8)));
    }

}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                int leftStart = start ,leftEnd = mid - 1;
                while (leftStart <= leftEnd) {
                    int leftMid = (leftStart + leftEnd) / 2;
                    if (nums[leftMid] < target) {
                        leftStart = leftMid + 1;
                    } else {
                        result[0] = leftMid;
                        leftEnd = leftMid - 1;
                    }
                }


                int rightStart = mid + 1 ,rightEnd = end;
                while (rightStart <= rightEnd) {
                    int rightMid = (rightStart + rightEnd) / 2;
                    if (nums[rightMid] > target) {
                        rightEnd = rightMid - 1;
                    } else {
                        result[1] = rightMid;
                        rightStart = rightMid + 1;
                    }
                }
                return result;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}


