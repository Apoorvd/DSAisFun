package com.heyshubham.leetcode;

public class LeetCode_34 {

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

    public int[] searchRange(int[] nums, int target) {
        int pos=binarySearch(nums,0,nums.length-1,target);
        if(pos==-1)
            return new int[]{-1,-1};
        if(nums[0]==nums[nums.length-1])
            return new int[]{0,nums.length-1};
        else
        {
            int i=pos,j=pos;
            while(nums[i]==nums[pos] && i>0)
                i--;
            while(nums[j]==nums[pos] && j<nums.length-1)
                j++;

            if(i==0 && nums[pos] == nums[i])
                return new int[] {i,j-1};
            if(j==nums.length-1 && nums[pos]==nums[j])
                return new int[] {i+1,j};

            return new int[] {i+1,j-1};
        }

    }
    public int binarySearch(int arr[], int first, int last, int element){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < element ){
                first = mid + 1;
            }else if ( arr[mid] == element ){
                return mid;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        return -1;
    }

    // second approach contains both of these functions
    public int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int searchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
