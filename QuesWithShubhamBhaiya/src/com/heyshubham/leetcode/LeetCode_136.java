package com.heyshubham.leetcode;

public class LeetCode_136 {

    //https://leetcode.com/problems/single-number/

    // Best approach using BITWISE XOR
    public int singleNumber(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;

    }
}

/* 4ms
public int singleNumber(int[] nums) {
        int[] freq = new int[60000];
        for (int i=0; i<nums.length; i++){
            freq[nums[i]+30000]++;
        }
        for (int i=0; i<freq.length; i++){
            if (freq[i]==1) return i-30000;
        }
        return 0;
    }
 */


/* 5ms

public int singleNumber(int[] nums) {
        if(nums.length == 1){  return nums[0];     }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i += 2){
            if(nums[i] != nums[i+1]){ return nums[i];  }
        }
        return nums[nums.length-1];
    }
 */