package com.array;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {

        int arr[] = {1 ,2 ,5 ,7 ,6 };
        System.out.println(minSum(arr));
    }

    static int minSum(int arr[])// not a valid solution, don't do this
    {
        Arrays.sort(arr);
        int n = arr.length;
        int s1,s2;
        s1 = sum(arr,0,n/2);
        s2 = sum(arr,n/2,n);
        int mid = n/2;
        while(s1 < s2)
        {
            s1 = s1 + arr[mid];
            s2 = s2 - arr[mid];
            mid ++;
        }
        return s1-s2;
    }
    static int sum(int arr[],int a, int b)
    {
        int sum = 0;
        for(int i = a; i < b; i++ )
        {
            sum = sum + arr[i];
        }
        return sum;

    }
}
