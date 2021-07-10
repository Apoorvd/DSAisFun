package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_229 {

    //https://leetcode.com/problems/majority-element-ii/

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1){
                count1++;
            }
            else if(nums[i] == number2){
                count2++;
            }
            else if(count1 == 0){
                number1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                number2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1){
                count1++;
            }
            else if(nums[i] == number2){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            res.add(number1);
        }
        if(count2 > nums.length / 3){
            res.add(number2);
        }
        return res;
    }
}


/*
public List<Integer> majorityElement(int[] nums) {
 //there should be at most 2 different elements in nums more than n/3
 //so we can find at most 2 elements based on Boyer-Moore Majority Vote algo
 List<Integer> res = new ArrayList<Integer>();
 if(nums.length==0) return res;
 int count1=0,count2=0,m1=0,m2=0;
 for(int n : nums){
     if(m1==n) count1++;
     else if(m2==n) count2++;
     else if(count1==0) {
         m1=n;
         count1=1;
     }
     else if(count2==0) {
         m2=n;
         count2=1;
     }
     else{
         count1--;
         count2--;
     }
 }
 count1=0;
 count2=0;
 //count the number for the 2 elements
 for(int n:nums){
     if(n==m1) count1++;
     else if(n==m2) count2++;
 }
 //if those appear more than n/3
 if(count1>nums.length/3) res.add(m1);
 if(count2>nums.length/3) res.add(m2);
 return res;

   }
 */

/*
public List<Integer> majorityElement(int[] a) {
  // we can only have maximum 2 majority elements
  int n = a.length;
  int c1 = 0, c2 = 0;
  Integer m1 = null, m2 = null;

  // step 1. find out those 2 majority elements
  // using Moore majority voting algorithm
  for (int i = 0; i < n; i++) {
    if (m1 != null && a[i] == m1)      { c1++; }
    else if (m2 != null && a[i] == m2) { c2++; }
    else if (c1 == 0)                  { m1 = a[i]; c1 = 1; }
    else if (c2 == 0)                  { m2 = a[i]; c2 = 1; }
    else                               { c1--; c2--; }
  }

  // step 2. double check
  c1 = 0; c2 = 0;

  for (int i = 0; i < n; i++) {
    if (m1 != null && a[i] == m1) c1++;
    if (m2 != null && a[i] == m2) c2++;
  }

  List<Integer> res = new ArrayList<Integer>();

  if (c1 > n / 3) res.add(m1);
  if (c2 > n / 3) res.add(m2);

  return res;
}
 */

/*
Nice use of quick sort

public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        quickSort(nums, 0, nums.length - 1, res, nums.length / 3);

        return res;
    }

    private void quickSort(int[] nums, int start, int end, List<Integer> res, int threshold) {
        if (end - start + 1 <= threshold) return;

        // the index of num less than current num
        int lt = start;
        // the index of num larger than current num
        int gt = end;
        // the current index
        int i = lt + 1;
        while (i <= gt) {
            if (nums[i] < nums[lt]) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] > nums[lt]) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        if (gt - lt + 1 > threshold) res.add(nums[lt]);

        quickSort(nums, start, lt - 1, res, threshold);
        quickSort(nums, gt + 1, end, res, threshold);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
 */