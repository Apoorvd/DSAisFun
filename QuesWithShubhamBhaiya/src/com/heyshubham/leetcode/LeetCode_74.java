package com.heyshubham.leetcode;

public class LeetCode_74 {

    //https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        return bsearch(0, matrix, target);
    }
    boolean bsearch(int start,int[][] arr, int x){
        int l = 0;
        int r = arr[0].length-1;
        // System.out.println(arr[start][l]);
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[start][m] == x)
                return true;
            if (arr[start][m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        if(start < arr.length-1)
        {
            if(arr[start+1][0] > x)
                return false;
            else
                return bsearch( start+1, arr, x);

        }
        return false;

    }
}

/*
0ms

public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m - 1, row = -1;

        // search in first column
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] < target)
                left = mid + 1;
            else if (matrix[mid][0] > target)
                right = mid - 1;
            else
                return true;
        }

        if (right >= 0 && right < m) {
            row = right; left = 0; right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] < target)
                    left = mid + 1;
                else if (matrix[row][mid] > target)
                    right = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }
 */

/*
public boolean searchMatrix(int[][] matrix, int target) {
         for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0] && target<=
               matrix[i][matrix[i].length-1]){
                for(int j=0;j<matrix[i].length;j++){
                    if(matrix[i][j]==target)return true;
                }
            }
        }
        return false;
    }

    // or u can use binary search instead of linear search
 */