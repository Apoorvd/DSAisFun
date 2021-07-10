package com.heyshubham.leetcode;

public class LeetCode_268 {
    //https://leetcode.com/problems/missing-number/

    public int missingNumber(int[] nums) {
        int sum=(nums.length*(nums.length+1))/2;
        for(int i=0;i<nums.length;i++)
        {
            sum-=nums[i];
        }
        return sum;
    }

}
