package com.heyshubham.leetcode;

public class LeetCode_169 {

    // https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorElmnt = 0;

        for (int i=0; i < nums.length; i++) {
            if (count == 0) {
                majorElmnt = nums[i];
            }
            count += (nums[i] == majorElmnt) ? 1 : -1;
        }

        return majorElmnt;
    }
}
