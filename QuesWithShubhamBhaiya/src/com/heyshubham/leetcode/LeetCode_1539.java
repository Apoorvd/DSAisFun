package com.heyshubham.leetcode;

public class LeetCode_1539 {

    // https://leetcode.com/problems/kth-missing-positive-number/
    public int findKthPositive(int[] arr, int k) {
        int a=0, missing=0;
        int i=0;
        while(i < arr.length)
        {
            if(arr[i]==a)
            {
                i++;
                a++;
            }
            else
            {
                if(missing == k)
                    return a;
                a++;
                missing ++;
            }
        }
        while(missing < k)
        {
            a++;missing++;
        }
        return a;
    }

    // also have a log n approach
}


