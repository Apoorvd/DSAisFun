package com.heyshubham.leetcode;

public class LeetCode_80 {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

    public int removeDuplicates(int[] nums) {
        return preserveKDuplicates(nums,2); // preserve atmost 2 duplicate elements
    }
    public int preserveKDuplicates(int[] nums,int k)
    {
        int i = 0;
        for (int n : nums)
            if (i < k || n > nums[i-k])
                nums[i++] = n;
        return i;
    }
}
