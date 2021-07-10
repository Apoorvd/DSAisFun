package com.heyshubham.leetcode;

import java.util.Arrays;

public class LeetCode_62 {

    //https://leetcode.com/problems/unique-paths/

    // mathematical solution
    public int uniquePaths(int m, int n) {
        m--;n--;
        //int N=m+n;
        //int r=min(m,n);
        double ans=1;
        // we are taking ans as double because if we divide ans by i there may some
        // some lost of precision in integer;
        for(int i=1;i<=Math.min(n,m);i++)
        {
            ans=ans*((m+n)-(i-1))/(i);
        }
        return (int)ans;
    }

    // dp solution

    public int uniquePaths_(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i : dp)
            Arrays.fill(i,1);

        for(int i = 1; i <m ;i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
