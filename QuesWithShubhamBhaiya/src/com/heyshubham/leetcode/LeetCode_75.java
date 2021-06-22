package com.heyshubham.leetcode;

public class LeetCode_75 {

    // https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        short i=0,j=0,k=0;
        for(int iter=0; iter < nums.length ; iter++)
        {
            if(nums[iter]==0)
                i++;
            else if(nums[iter] == 1)
                j++;
            else
                k++;
        }
        int iter=0;
        while(i--!=0)
            nums[iter++]=0;
        while(j--!=0)
            nums[iter++]=1;
        while(k--!=0)
            nums[iter++]=2;
    }
}
