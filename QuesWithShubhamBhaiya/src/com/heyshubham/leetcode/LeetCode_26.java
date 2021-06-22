package com.heyshubham.leetcode;

public class LeetCode_26 {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array
    public int removeDuplicates(int[] nums) {
        int uniqueptr=0,currptr=0,temp=0;
        if(nums.length<=1)
            return nums.length;
        while(currptr!=nums.length-1)
        {
            while(nums[currptr]==nums[uniqueptr] && currptr<nums.length-1 )
            {
                currptr++;
            }
            uniqueptr++;
            //swap values at currptr and unique ptr
            // if(nums[currptr]!=nums[uniqueptr])

            temp=nums[uniqueptr];
            nums[uniqueptr]=nums[currptr];
            nums[currptr]=nums[uniqueptr];

            // uniqueptr--;
            //System.out.println(Arrays.toString(nums));
        }
        if(nums[uniqueptr-1]==nums[uniqueptr])
            return uniqueptr;
        else
            return uniqueptr+1;
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,2,3,4,4,5,5,5,5,6,7};

    }
}
