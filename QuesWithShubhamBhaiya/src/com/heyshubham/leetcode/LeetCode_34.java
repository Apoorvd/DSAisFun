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

    //
    /*
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        res[0]=nums.length!=0?lowerBound(nums,0,nums.length-1,target):-1;
        res[1]=nums.length!=0?upperBound(nums,0,nums.length-1,target):-1;
        return res;

    }
    public int lowerBound(int nums[], int left, int right,int x){
        if(left==right){
            if(nums[left]==x)
                return left;
            else
                return -1;
        }
        int mid =left+(right-left)/2;
        if(x<=nums[mid]){
            return lowerBound(nums,left,mid, x);
        }else{
            return lowerBound(nums, mid+1, right, x);
        }
    }
    public int upperBound(int nums[],int left, int right,int x){
        if(left==right){
            if(nums[left]==x)
                return left;
            else
                return -1;
        }
        int mid =left+(right-left+1)/2;
        if(x>=nums[mid]){
            return upperBound(nums,mid,right, x);
        }else{
            return upperBound(nums, left, mid-1, x);
        }
    }
     */

    /*
    private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}
     */

    /*
    public int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		int lo = 0, hi = nums.length - 1;

		//lo is the start index of target
		//hi is the end index of target
		while(nums[lo] < nums[hi]) {
			int mid = lo + (hi - lo)/2;
			if(nums[mid] > target) {//target is in the left half
				hi = mid - 1;
			} else if(nums[mid] < target) {// target is in the right half
				lo = mid + 1;
			} else {//find target, then need to find the start and end point
				if(nums[lo] == nums[mid]) {
					hi--;
				}else {
					lo++;
				}
			}
		}
		//check whether find the target number
		if(nums[lo] == nums[hi] && nums[lo]== target) {
			res[0] = lo;
			res[1] = hi;
		}

		return res;
	}
     */
}
