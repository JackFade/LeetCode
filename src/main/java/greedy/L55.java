package greedy;

/*
*
* 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/
public class L55 {
    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        System.out.println(new Solution55().canJump(new int[]{0}));
        System.out.println(new Solution55().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution55().canJump(new int[]{3,2,1,0,4}));
    }
}

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] maxStep = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxStep[i] = i + nums[i];
        }

        int index = 0;
        int maxIndex = maxStep[index];

        while (index < nums.length && index <= maxIndex) {
            if (maxIndex < maxStep[index]) {
                maxIndex = maxStep[index];
            }
            index++;
        }
        if (index == nums.length) {
            return true;
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        if(nums==null||nums.length<1){
            return false;
        }
        int index = nums.length - 1;
        for(int i=nums.length-2;i>=0;--i){
            if(i+nums[i]>=index){
                index = i;
            }
        }
        return index<=0;
    }
}