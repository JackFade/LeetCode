package greedy;

/*

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。

*/
public class L45 {
    public static void main(String[] args) {
        System.out.println(new Solution45().jump(new int[]{2,3,1}));
        System.out.println(new Solution45().jump(new int[]{1,1,1,1}));
        System.out.println(new Solution45().jump(new int[]{1,2,3}));
        System.out.println(new Solution45().jump(new int[]{1,2}));
        System.out.println(new Solution45().jump(new int[]{2,3,1,1,4}));
    }
}

class Solution45 {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int minStep = 1; // 最小步长
        int maxIndex = nums[0]; // 当前可达最大位置
        int preMaxIndex = nums[0]; // 上一轮可达最大位置

        for (int i = 1; i < nums.length && preMaxIndex < nums.length - 1; i++) {
            if (i > preMaxIndex) { // 已经超过上一步可达的最大距离，说明已经新走了一步
                minStep++;
                preMaxIndex = maxIndex;
            }

            if (i + nums[i] > maxIndex) {
                maxIndex = i + nums[i];
                if (maxIndex >= nums.length - 1) {
                    return minStep + 1;
                }
            }
        }
        return minStep;
    }
}