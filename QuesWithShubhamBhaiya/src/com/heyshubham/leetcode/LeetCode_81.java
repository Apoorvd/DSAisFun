package com.heyshubham.leetcode;

public class LeetCode_81 {
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;
                start++;
            }
        }

        return false;
    }
}

/* 0ms
public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return true;
            }
            if(nums[mid] > nums[start]) {
                // left side is sorted
                if(target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            } else if(nums[mid] < nums[start]) {
                //right side is sorted
                if(target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
 */

/* 1ms
 public boolean search(int[] nums, int target) {
        // [4,5,6,7,0,1,2]
        // [4,5,6,7,0,1,2,4,5,6,7,0,1,2]

        int n = nums.length;
        int lo = 0, hi = n * 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int mod = mid % n;
            if (nums[mod] == target) {
                return true;
            }
            if (nums[mod] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
 */