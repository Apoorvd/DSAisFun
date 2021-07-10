package com.heyshubham.leetcode;

import java.util.Arrays;

public class LeetCode_31 {

    // https://leetcode.com/problems/next-permutation/

        public void nextPermutation(int[] nums) {
            int i ;
            for(i = nums.length-1;i > 0 ; i-- )
            {
                if ( nums[i] <=nums[i-1])
                    continue;
                else
                    break;

            }
            if ( i == 0)
                reverse(nums);
            else
            {
                Arrays.sort(nums, i , nums.length);
                int j=i;
                while( nums[i-1] >=nums[j])
                {
                    j=j+1;
                }
                int temp = nums[j];
                nums[j]= nums[i-1];
                nums[i-1] = temp;
                return;
            }
        }
        public void reverse(int a[])
        {
            int i=0,j = a.length-1;
            while( i < j)
            {
                int temp = a[i];
                a[i++] = a [j];
                a[j--] = temp;
            }
        }
    }



    /*
    public void nextPermutation(int[] nums) {
        int  i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j -- ;
            }

        swap(nums, i, j);
    }

    reverse(nums, i+1);
}

public void reverse(int[] nums, int si) {
         int i = si, j = nums.length - 1;
         while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
}

void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
     */
    /*
    public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
     */


    /*
    public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
     */
    /*
    public void nextPermutation(int[] a) {
    int i = a.length - 1;
    while(i - 1 >= 0 && a[i-1] >= a[i]) i--; // In the end, a[i..a.length-1] will be reverse sorted
    if(i - 1 >= 0) {
        int j = a.length - 1;               // Need to pick an element a[j] in a[i..a.length-1] and swap it with a[i-1]
        while(a[i-1] >= a[j]) j--;          // finding a[j] - the smallest element larger than a[i-1] in a[i..a.length-1]
        swap(a, i-1, j);
    }
    Arrays.sort(a, i, a.length);           // sorting in ascending order will guarantee smallest next element
}

private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
}
     */


/*
 public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int pos = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > pos; i--) {
            if (nums[i] > nums[pos]) {
                swap(nums, i, pos);
                break;
            }
        }
        reverse(nums, pos + 1, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
 */

