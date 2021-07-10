package com.heyshubham.leetcode;

public class LeetCode_240 {
    //https://leetcode.com/problems/search-a-2d-matrix-ii/

    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. o(mlogn)
        // if(matrix.length == 0 || matrix[0].length == 0) return false;
        // int m = matrix.length, n = matrix[0].length;
        // for(int i = 0; i < m; ++i) {
        //     if(target <= matrix[i][n-1]) {
        //         int start = 0, end = n - 1;
        //         while(start <= end) {
        //             int mid = (start + end) / 2;
        //             if(matrix[i][mid] == target) return true;
        //             else if(matrix[i][mid] < target) start = mid + 1;
        //             else end = mid - 1;
        //         }
        //     }
        // }
        // return false;

        // 2. o(m+n)
        // int i = 0, j = matrix[0].length-1;
        // while(i < matrix.length && j >= 0) {
        //     if(matrix[i][j] == target) return true;
        //     else if(matrix[i][j] < target) i++;
        //     else j--;
        // }
        // return false;

        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j <= matrix[0].length - 1){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) i--;
            else j++;
        }
        return false;

    }
}
