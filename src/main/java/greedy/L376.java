package greedy;

/*

如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

示例 1:

输入: [1,7,4,9,2,5]
输出: 6
示例 2:

输入: [1,17,5,10,13,15,10,5,16,8]
输出: 7
示例 3:

输入: [1,2,3,4,5,6,7,8,9]
输出: 2
进阶:
你能否用 O(n) 时间复杂度完成此题?
*/
public class L376 {
    public static void main(String[] args) {
        System.out.println(new Solution376().wiggleMaxLength(new int[]{0,0}));
    }
}

class Solution376 {
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;
        int status = BEGIN;
        int maxCnt = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (status == BEGIN) {
                if (diff > 0) {
                    status = UP;
                    maxCnt++;
                } else if (diff < 0) {
                    status = DOWN;
                    maxCnt++;
                }
            } else if (status == UP) {
                if (diff < 0) {
                    status = DOWN;
                    maxCnt++;
                }
            } else {
                if (diff > 0) {
                    status = UP;
                    maxCnt++;
                }
            }
        }
        return maxCnt;
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int preVal = nums[1] - nums[0];
        int maxCnt = preVal == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if (diff * preVal < 0 || (preVal ==0 && diff != 0)) {
                maxCnt++;
                preVal = diff;
            }
        }
        return maxCnt;
    }
}