package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_189 {
    //https://leetcode.com/problems/rotate-array/

    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if(k==0 || k%n==0)
            return;
        k=k%n;
        System.out.println(k);
        int i,j=0;
        for ( i = 0 ; i < n-k ; i++)
        {
            list.add(nums[i]);
        }
        for( ; i < n; i++)
        {
            nums[j++]=nums[i];
        }
        i=0;
        for ( ; j < n; j++)
        {
            nums[j]=list.get(i++);
        }

    }
}

/*
public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate___(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        int start = 0;
        while (count < n) {
            int cur = start;
            int prev = nums[start];
            do {
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (start != cur);
            start++;
        }
    }

    // use a new arry
    public void rotate_(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    // sumilate rotating array step by step (k steps in total)
    public void rotate__(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int prev = nums[n - 1];
            for (int j = 0; j < n; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }
 */