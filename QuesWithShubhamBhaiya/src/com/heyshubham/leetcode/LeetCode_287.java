package com.heyshubham.leetcode;

public class LeetCode_287 {

    //https://leetcode.com/problems/find-the-duplicate-number/

    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
/* mathematical

public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] *= -1;
            else return Math.abs(nums[i]);
        }
        return 0;
    }
 */

/* 2ms
public int findDuplicate(int[] nums) {
        int [] counter = new int[nums.length];
        int duplicate = 0;
        for(int k: nums){
            if(counter[k] == 0){
                counter[k]++;
            }
            else{
                duplicate = k;
                break;
            }
        }
        return duplicate;
    }
*/

/* damn nice
public int findDuplicate(int[] nums) {

        int nums2[] = new int[nums.length];
        int i = 0;
        while (nums2[nums[i]] == 0){
            nums2[nums[i]] = nums[i];
            i++;
        }
        return nums[i];

    }
 */