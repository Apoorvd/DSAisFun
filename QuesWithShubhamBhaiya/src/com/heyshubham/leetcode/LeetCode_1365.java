package com.heyshubham.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1365 {

    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums == null || nums.length<2)
            return new int [0];
        int[] sorted= nums.clone();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(sorted);
        for(int i=0; i<sorted.length;i++) {
            if(!map.containsKey(sorted[i]))
            {
                map.put(sorted[i], i);
            }
        }
        int[] result= new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}

/*
2ms
public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] n = new int[101];
        for(int i=0;i<nums.length;i++){
            n[nums[i]]++;
        }
        for(int i=1;i<101;i++){
            n[i] +=  n[i-1];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                nums[i] = 0;
            else
                nums[i] = n[nums[i]-1];
        }
        return nums;
    }
 */

/*
// Without running sum
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countArray = new int[101];

        for(int val : nums)
            countArray[val]++;

        int valuesSeenBefore = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > 0) {
                int tempCount = countArray[i];
                countArray[i] = valuesSeenBefore;
                valuesSeenBefore += tempCount;
            }
        }

        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            out[i] = countArray[nums[i]];
        }

        return out;
    }
 */

/*
 // Running sum .. similar to dp
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[102];
        for(int i=0; i<nums.length; i++)
            bucket[nums[i]+1]++;

        for(int i=1; i<102; i++)
            bucket[i] += bucket[i-1];

        for(int i=0; i<nums.length; i++)
            nums[i] = bucket[nums[i]];

        return nums;

    }
 */

/*
public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] return_arr = new int[nums.length];
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (smallest > nums[i]) {
				smallest = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int less = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i] && j != i) {
					less++;
				}
			}
			return_arr[i] = less;
		}
		return return_arr;
    }
 */


/*
public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(i!=j && val>nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
 */