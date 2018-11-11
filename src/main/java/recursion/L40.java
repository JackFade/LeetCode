package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

*/

public class L40 {
    public static void main(String[] args) {
        System.out.println(new Solution40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        generateResult(0, candidates, new ArrayList<>(),0, target, result);
        return result;
    }

    private void generateResult(int index, int[] candidates, ArrayList<Integer> items, int itemsSum, int target, List<List<Integer>> result) {
        for (int i = index; i < candidates.length; i++) {
            if ((i > index && candidates[i] == candidates[i-1])) {
                continue;
            }

            int addItemsSum = itemsSum + candidates[i];

            if (addItemsSum > target) {
                break;
            } else if (addItemsSum == target) {
                List<Integer> targetItem = new ArrayList<>(items);
                targetItem.add(candidates[i]);
                result.add(targetItem);
                break;
            } else {
                items.add(candidates[i]);
                generateResult(i + 1, candidates, items, addItemsSum, target, result);
                items.remove(items.size() - 1);
            }
        }
    }
}
