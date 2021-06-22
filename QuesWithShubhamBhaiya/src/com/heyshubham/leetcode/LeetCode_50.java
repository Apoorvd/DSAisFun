package com.heyshubham.leetcode;

public class LeetCode_50 {

    //https://leetcode.com/problems/powx-n/

    public double myPow(double x, int n) {
            if(n==0)
                return 1;
            double temp = myPow(x,n/2);
            if(n%2 == 0)
                return temp*temp;
            else {
                if( n > 0)
                    return x*temp*temp;
                else
                    return (temp*temp)/x;
            }
        }

}
