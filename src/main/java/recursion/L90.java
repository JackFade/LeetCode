package recursion;

import java.util.*;


/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

public class L90 {
    public static void main(String[] args) {
        System.out.println(new Solution90().subsetsWithDup2(new int[]{1,2,2,3,3}));
    }
}

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);

        generateResult(0, nums, new ArrayList<Integer>(), result);

        List<List<Integer>> resultList = new ArrayList<>(result.size());
        for (List<Integer> integers : result) {
            resultList.add(integers);
        }
        return resultList;
    }

    private void generateResult(int i, int[] nums, ArrayList<Integer> item, Set<List<Integer>> result) {
        if (i >= nums.length) {
            return;
        }

        generateResult(i+1, nums, item, result);
        item.add(nums[i]);
        result.add(new ArrayList<>(item));
        generateResult(i+1,nums, item, result);
        item.remove(item.size() - 1);
    }



    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> reslut = new ArrayList<>();
        Arrays.sort(nums);
        func(reslut, nums, new ArrayList<>(), 0);
        return reslut;
    }

    void func(List<List<Integer>> results, int[] nums, List<Integer> item, int index) {

        results.add(new ArrayList<>(item));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            item.add(nums[i]);
            func(results, nums, item, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
