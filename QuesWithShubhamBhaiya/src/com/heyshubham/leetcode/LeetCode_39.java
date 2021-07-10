package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_39 {

    //https://leetcode.com/problems/combination-sum/

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

/* 2ms
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, res, new ArrayList<>(), 0);
        return res;

    }
    public static void combine(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        else if (target < candidates[start]){
            return;
        }
        else {
            for (int i = start; i<candidates.length; i++) {
                if (candidates[i] <= target) {
                    tmp.add(candidates[i]);
                    target-=candidates[i];
                    combine(candidates, target, res, tmp, i);
                    target+=candidates[i];
                    tmp.remove(tmp.size()-1);
                }
                else {
                    return;
                }
            }
        }
    }

 */

/* 2ms
public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] comb = new int[candidates.length];
        List<List<Integer>> result = new ArrayList<>();

        recurse(candidates, target, 0, comb, result);

        return result;
    }

    private void recurse(int[] candidates, int target, int start,
                         int[] comb, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                for (int cnt = 0; cnt < comb[i]; cnt++) {
                    combination.add(candidates[i]);
                }
            }

            result.add(combination);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            comb[i]++;
            recurse(candidates, target - candidates[i], i, comb, result);
            comb[i]--;
        }
    }
 */

/* 1ms
List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        output = new ArrayList<>();
        backTrack(candidates, 0, 0, target, new LinkedList<Integer>());
        return output;
    }

    public void backTrack(int[] candidates, int index, int currSum, int target, LinkedList<Integer> list) {
        if(currSum == target) {
            output.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            if(currSum + candidates[i] <= target) {
                //place
                list.add( candidates[i]);
                currSum = currSum + candidates[i];
                backTrack(candidates, i, currSum, target, list);
                list.removeLast();
                currSum = currSum - candidates[i];
            }
        }
    }
 */
