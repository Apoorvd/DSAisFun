package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {

    // 1ms or 0 ms
    //https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> PowerSet = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        ps( PowerSet, set, nums, 0);
        return PowerSet;
    }
    public void ps(List<List<Integer>> PowerSet,List<Integer> set, int[] nums, int start)
    {
        PowerSet.add(new ArrayList<>(set));
        for(int i = start; i < nums.length; i++){
            set.add(nums[i]);
            ps( PowerSet,set, nums, i + 1);
            set.remove(set.size() - 1);}
    }
}


/* Using BIT MANIPULATION

 public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        //n - size of nums
        int n=nums.length;

        //Interating - 2^n times
        //All the 2^n subsets
        for(int i=0;i<(1<<n);i++){
            List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<n;j++){
                //i & 1<<j - not equal
                if((i&(1<<j))>0){
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }

        return res;
    }
 */

/* 2ms or 1ms
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0){
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        dfs(0,nums,list,ans);
        return ans;
    }

    public void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
                list.add(nums[i]);
                //visited[i] = true;
                dfs(i+1,nums,list,ans);
                //visited[i] = false;
                list.remove(list.size()-1);

        }
    }
 */


/* different approach
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        for(int num:nums){
            List<List<Integer>> copy = new ArrayList<>();
            for(int i = 0; i < res.size(); i++){
                List<Integer> newList = new ArrayList<>(res.get(i));
                newList.add(num);
                copy.add(newList);
            }
            res.addAll(copy);
        }
        return res;
    }
 */
