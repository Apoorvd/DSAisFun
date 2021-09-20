package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class exp2 {

        static int FindContiguousSeq(int input1, int input2[])
        {
            int max_so_far = 0;
            int curr_max = 0;

            for (int i = 0; i < input1; i++)
            {
                if(input2[i] > 0){
                curr_max = Math.max(input2[i], curr_max+input2[i]);
                max_so_far = Math.max(max_so_far, curr_max);}
                else
                {
                    curr_max = 0;
                }
            }

            return max_so_far;
        }


    static String leftrotate(String str, int d)
    {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    // function that rotates s towards right by d
    static String rightrotate(String str, int d)
    {
        return leftrotate(str, str.length() - d);
    }

    // Driver code
    public static void main(String[] args)
    {

        int a[] = {7,2,3,-1,-1,4,3};
        int b[] = {4606,2752,3447,6298,2713, 9448, 2316, 4898};
        System.out.println(FindContiguousSeq(7,a));
    }
}

//input3[0],
//input3[last],
//
//input4[0]
//input4[last]
