package com.heyshubham.leetcode;

import java.util.Arrays;

public class LeetCode_300 {
    //https://leetcode.com/problems/longest-increasing-subsequence/

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}

/*
 public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 0, N = nums.length;
        int[] tailTable = new int[N];
        tailTable[len++] = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] < tailTable[0]) tailTable[0] = nums[i];
            else if (nums[i] > tailTable[len - 1]) tailTable[len++] = nums[i];
            else {
                tailTable[binarySearch(tailTable, 0, len - 1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] tails, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start)/2;
            if (tails[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
 */

/*
 public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 0, N = nums.length;
        int[] tailTable = new int[N];
        tailTable[len++] = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] < tailTable[0]) tailTable[0] = nums[i];
            else if (nums[i] > tailTable[len - 1]) tailTable[len++] = nums[i];
            else {
                tailTable[binarySearch(tailTable, 0, len - 1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] tails, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start)/2;
            if (tails[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
 */

/*
public int lengthOfLIS(int[] nums) {
        int[] list = new int[nums.length];
        list[0] = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list[count - 1]) {
                list[count++] = nums[i];
            }
            else if (nums[i] < list[count - 1]) {
                for (int j = 0; j < count; j++) {
                    if (list[j] >= nums[i]) {
                        list[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return count;
    }
 */


 /*
 public int lengthOfLIS(int[] nums) {
        int dp [] = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for(int n:nums){
            if(n<=dp[0])
                dp[0]=n;
            else if(n>dp[len-1])
                dp[len++] = n;
            else
                dp[bst(dp, 0, len, n)] = n;
        }
        return len;
    }

    public int bst(int [] dp, int start, int end, int n){
        while(end-start>1){
            int mid = start+ (end-start)/2;
            if(dp[mid]< n)
                start = mid;
            else
                end = mid;
        }

        return end;
    }

}

/*
Given:
- Integer [nums]

Return
- length of longest /strictly increasing/ subsequence

subsequence can be drvied from an array by deleting some or no elements without changing the order of the remaining elements.

Create a List
    - Evaluate on (3) Cases while going from nums[0]->nums[end]:
        - Case #1
            if nums[i] < All list "ends"
                Create a new List & list.add(nums[i]);
        - Case #2
            if nums[i] > All list "ends"
                Clone the list w/ Largest "end"
                    list.add(nums[i]);
        - Case #3
            if nums[i]> smallest List-end && nums[i] < greatest list-end
                find the list with the largest list-end thats also less than nums[i];
                    Clone and list.add(nums[i]);
                    Delete all other list that are of same length.

Iterative Solution O(n^2)
- We start from the end of the array and move down end-> start
    - We see the longest subsequence of the last value, and store the length in dp[]
    -Then we go down to the next value
        The next value compares itself to all the other "Max-Lengths" in the dp[] of indexs in front of it.
            ex. if nums[i] < nums[j]   // i is the current index, j is the indexes that we're checking in front of us
                    == True
                        Then we compare the dp (which contains length) of i and j and see which one is bigger
                            Since dp[i] initially has length 1 because it's a sequence of itself, we use that
                                dp[j] will be dp[j]+1, since (1) we verified that nums[j] is greater than nums[i]
                                    and we're now including the current index with it's sequence.
    - Eventually when we have all the "longest" sequences in the dp[], we can just find the largest value.


Iterative (nlogn)
Using what we learned in the geeks4geeks
 - Start from the left -> right
 - Use a dp[] to keep track of "tails"
    - Each index represents a "list length"
        each index value represents the "tail"

 3 Cases to take note of:
 - If nums[i] is the smaller than the all the other tails from dp[0->currentEnd]
        - Then, it replaces the current value at index dp[0];
 - If nums[i] is larger than all the other fails from dp[0->currentEnd]
        - Then, we put nums[i] at dp[currentEnd+1]
            - Why? Because the nums[i] is bigger than all the other tails,
                Including the one at dp[currentEnd]. With this, we can pretend that
                we're adding nums[i] to the end of the sequence where nums[currentEnd] is the tail
                    [Remember, the indexes in dp[] represent lengths], so if dp[4] = 5, but nums[i] = 6,
                     then we can pretend to add 6 to the end of the list of dp[4] *,*,*,4,6. length now is 5
                     dp[5] = 6;
 - If nums[i] is neither the smallest nor largest.
        - This should be added  to any existing list

[ 2, 5, 3, 7]


while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }



1   2
2   5
3
4


a[2] = 3
tailTable[bs()]

Wait, adding the numbers to the dp[] will automatically sort them as well?
 = Answer: YES
        - num[i] is Lower than all tails, it replaces the one at the end
            dp[0] is now the lowest value
        - num[i] is larger than all tails
            dp[curr+1] is now the largest value
        - nums[i] is inbetween the largest and smallest
            dp[X] = nums[i]
                - Uses BST to find the largest number smallest tha nums[i].
                    ex. nums[i] > dp[ 4] but is less than dp[5] ( dp[4] < nums[i] < dp[5])
                        nums[i] will now take over dp[5] (AKA dp[calculatedIndex+1].
                            Why? Because we will pretend to "add it" to the sequence holding dp[4]'s tail
                            "Won't this cause issues?"
                                - No it won't. By reaching this point, dp[5] was either already included in a sequence
                                    or is an outlier that wasn't able to extend it's sequence anymore (up til this point)
                                    Since nums[i] <dp[5], we can safely replace dp[5] with nums[i], since nums[i] is
                                    smaller than dp[5] and has more opportunities to continue it's sequence.



public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int len = 1;
        dp[0] = nums[0];
        for(int n: nums){
            if(n<=dp[0])
                dp[0] = n;
            else if (dp[len-1] < n)
                dp[len++] = n; // Or dp[len] = n; len = len+1 AKA len++;
            else{ // indication that n is niether largest or smallest, and can be added as the end of some sequence

                // bst() Searches for a index that is next biggest Value to n
                // Returns -1 if n is already a tail. If it is, then theres no need to re-add and we can ignore.
                int adjustedInd = bst(dp, 0, len, n);
                if(adjustedInd != -1)
                    dp[adjustedInd] = n;
            }
        }


        return len;
    }

    public int bst(int [] dp, int start, int end, int val){
        while(end-start>1){
            int mid = start + (end - start)/2;
            if(dp[mid] == val)
                return -1;
            else if(dp[mid] > val)
                end = mid;
            else if(dp[mid] < val)
                start = mid;
        }
        // At this point,   dp[start]/dp[mid] < val < dp[end]
        return end;
    }




*/








