package com.heyshubham.leetcode;

public class LeetCode_33 {

    //https://leetcode.com/problems/search-in-rotated-sorted-array/

    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }


    /*
     public int search(int[] nums, int target) {
        int k = findK(nums);
        int n = nums.length;
        if( k == 0)
            return binarySearch(nums, 0, n-1, target);
        if( nums[k] == target)
            return k;
        if(nums[n-1] < target)
            return binarySearch(nums , 0 , k-1, target);
        else
            return binarySearch(nums, k, n-1, target);
    }
    public int binarySearch(int nums[],int l,int r, int target)
    {
        int mid;
         while(l <= r)
        {
            mid=(l+r)/2;
            if( target > nums[mid])
            {
                System.out.println(l+" "+r);
                l = (mid +1);
            }
            else if( target < nums[mid])
            {
                r = (mid -1);
            }
            else
                return mid;
        }
        return -1;
    }
    public int findK(int nums[])
    {
        int l = 0, r=  nums.length-1;
        int mid;
        while(l < r)
        {
            mid = (l+r) / 2;
            if( nums[l] > nums[r])
            {
                if(nums[mid] > nums[r]){
                    if( r == l+1)
                        return r;
                    l=mid;
                }
                else
                    r=mid;
            }
            else if( nums[l] < nums[r])
            {
                return l;
            }
            else
                return mid;
        }
        return l;
    }
  }
     */
    /*
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, 0, n-1);
       // System.out.println(pivot);
        if(pivot == -1)
           return binarySearch(nums, 0,n-1, target);
        if(nums[pivot] == target )
            return pivot;
        else if(nums[0] > target)
            return binarySearch(nums, pivot+1, n-1, target);
        else
            return binarySearch(nums, 0, pivot-1, target);

    }

    public int binarySearch(int[] nums, int lo, int hi, int target){
        while(lo <= hi){
            int mid = hi - (hi-lo)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return -1;
    }

    public int findPivot(int[] nums ,int lo, int hi){
        if(lo > hi)
            return -1;
        if(lo==hi)
            return lo;

        while(lo <=hi){
            int mid = hi - (hi-lo)/2;
            if(mid < hi &&  nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > lo &&  nums[mid] < nums[mid-1])
                return mid-1;
            if(nums[mid] > nums[lo])
            {
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return -1;

    }
     */
    /*
     public int search(int[] nums, int target) {
        //Arrays.sort(nums);
        int n=nums.length;
        if(nums==null)
            return -1;
        int i=0;
        while(i<n)
        {
            if(nums[i]==target)
                return i;
            else
                i=i+1;
        }
        return -1;
    }
     */
}
