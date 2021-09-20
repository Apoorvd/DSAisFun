package com.array;

import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;

public class twoDmatrix {
    public static void main(String[] args)throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
//        int arr[] = new int[n];
//        int arr2[] = new int[n];
        String str[] = s.split(" ");
//        for (int i = 0; i < n ; i ++)
//            arr[i] = Integer.parseInt(str[i]);
//        s= in.readLine();
//        str = s.split(" ");
//        for( int i = 0; i < n; i ++)
//            arr2[i] = Integer.parseInt(str[i]);
//
//        System.out.println(scholar(n, arr,arr2));

//        s = in.readLine();
//        str= s.split(" ");

        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);

        int a[][] = new int[c][r];
        for(int i = 0; i < r; i++)
        {
            s=in.readLine();
            str = s.split(" ");
            a[i][0] = Integer.parseInt(str[0]);
            a[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(a[0]);

        for(int i = 0; i < r; i ++)
        {
            System.out.print(a[i][0] + " ");
            System.out.println(a[i][1]);
        }

    }
    static int scholar(int n, int arr1[], int arr2[])
    {
        int c=0;
        for(int i = 0; i < n; i ++)
        {
            if(arr1[i] != arr2[i])
            {
                c++;
            }
        }
        return c;
    }
}
