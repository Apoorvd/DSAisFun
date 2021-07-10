package com.heyshubham.leetcode;

import java.util.Arrays;

public class LeetCode_532 {
    //https://leetcode.com/problems/k-diff-pairs-in-an-array/
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=1;
        int c=0;
        while(j<nums.length )
        {
            if(Math.abs(nums[i]-nums[j]) < k)
            {
                j++;continue;
            }
            else if(Math.abs(nums[i]-nums[j]) > k)
            {
                i++;
                j=i+1;
            }
            else
            {
                c++;
                while(i<nums.length-1 && nums[i]==nums[i+1])
                    i++;
                i++;
                j=i+1;
            }
        }
        return c;
    }
}

/* Explained well
public int findPairs(int[] nums, int k) {


        // 0 1 2 3 4
        // 3 1 4 1 5
        // | |     |
      //   i m     j

       // Gotcha; unique pairs - hashset to push each k to hashset.

        //HashSet<Integer> uniqueMvalues = new HashSet();
        Arrays.sort(nums);

        int left =0;
        int right = left+1;

       // if(nums.length==1) return 0;


        int count =0;



            //count = Math.abs(nums[i]-nums[j]) == k ? count++ : count;

        while(left<nums.length && right < nums.length) {


            //if(!uniqueMvalues.contains(nums[m])) {
         //   int diff = Math.abs(nums[left]-nums[right]);

            int diff =  nums[right] - nums[left];

            if(left == right || diff < k) {
                right++;
            } else if (diff>k) {
                left++;

            } else {

                count+=1;
                left++;

                while(left < nums.length && nums[left]==nums[left-1]) {
                    left++;
                }
            }
        }



        return count;



    }
 */

/*
public int findPairs(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0, j = 0; i < n; ++i) {
            if (i == j) {
                ++j;
            }
            while (i + 1 < n && nums[i] == nums[i+1]) {
                ++i;
            }
            while (j + 1 < n && nums[j] == nums[j+1]) {
                ++j;
            }
            while (j < n && Math.abs(nums[j] - nums[i]) < k) {
                ++j;
            }
            if (j >= n) {
                break;
            }
            if (Math.abs(nums[j] - nums[i]) == k) {
                ++ans;
                ++j;
            }
        }

        return ans;
    }
 */