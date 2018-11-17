package recursion;

import java.util.Arrays;
import java.util.List;


/*

还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其 长度表示。输出即为是否能用所有的火柴拼成正方形。

示例 1:

输入: [1,1,2,2,2]
输出: true

解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: [3,3,3,3,4]
输出: false

解释: 不能用所有火柴拼成一个正方形。
注意:

给定的火柴长度和在 0 到 10^9之间。
火柴数组的长度不超过15。

*/

public class L473 {
    public static void main(String[] args) {
        System.out.println(new Solution473().makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
}

class Solution473 {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = maxNum < nums[i] ? nums[i] : maxNum;
        }

        int edge = sum / 4;
        if (sum % 4 != 0 || edge < maxNum) {
            return false;
        }

        Arrays.sort(nums);

        return makesquare(0, edge, new int[4], nums);
    }

    private boolean makesquare(int index, int edge, int[] buckets, int[] nums) {

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[nums.length - index - 1] <= edge) {
                if (index == nums.length-1) {
                    return true;
                } else {
                    int[] newBuckets = Arrays.copyOf(buckets, buckets.length);
                    newBuckets[i] = newBuckets[i] + nums[nums.length - index - 1];
                    if(makesquare(index + 1, edge, newBuckets, nums)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
