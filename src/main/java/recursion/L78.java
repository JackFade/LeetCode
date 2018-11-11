package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class L78 {
    public static void main(String[] args) {
        System.out.println(new Solution78().subsets(new int[]{1,2,3}));
    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> item = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));
        generateResult(0, nums, item, result);
        return result;
    }

    private void generateResult(int i, int[] nums, List<Integer> item, List<List<Integer>> result) {
        if (i == nums.length) {
            return;
        }

        item.add(nums[i]);
        List<Integer> resultItem= new ArrayList<>(item);
        result.add(resultItem);
        generateResult(i+1, nums, item, result);
        item.remove(item.size()-1);
        generateResult(i+1, nums, item, result);

    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());//[]空集
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                List<Integer> tmp=new ArrayList<Integer>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
