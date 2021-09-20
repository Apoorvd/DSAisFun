package com.array;

import java.util.Arrays;

public class dp2dmatrix {
    public static void main(String[] args) {
        int a[][] = {
                {1,3},
                {2,5},
                {2,4},
                {3,5}};

        int dp[][] = new int[3][3];
//        System.out.println(fun(10,7));

        int arr[] = {1,2,5,10};
//        System.out.println(f1(4,a));

        int dest = 10;
        System.out.println("No. of steps required"+
                " to reach " + dest +
                " is " + steps(0, 0, dest, 11));
    }
    static int minCost(int cost[][], int m,
                       int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] +
                    min( minCost(cost, m-1, n-1),
                            minCost(cost, m-1, n),
                            minCost(cost, m, n-1) );
    }
    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
    static int fun(int x, int y)
    {
        if ( x < y)
            return fun(y,x);
        else if(y != 0)
        {
            int z = fun(x, y-1);
            z = z + x;
            return z;
        }
        else
            return 0;
    }
    static long countWays( int n)
    {
        int S[] = {1,2,5,10};
        int m = 4;

        long[] table = new long[n+1];
        Arrays.fill(table, 0);   //O(n)
        table[0] = 1;

        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }
    static int f1(int input1, int input2[][])
    {
        int max  = 0;
        for( int i = 0; i < input1; i++)
        {
            if(max < input2[i][1])
                max = input2[i][1];
        }
        int res = 0;
        for(int i = 1 ; i <= max; i ++)
        {
            int m = 0;
            for(int j = 0; j < input1; j++)
            {
                if(input2[j][0] <= i && input2[j][1] > i)
                    m++;
            }
            System.out.println(m);
            res = Math.max(m,res);

        }
        return res;
    }

    static int steps(int source, int step,
                     int dest, int n)
    {
        // base cases
        int neg = Integer.MAX_VALUE;
        if (Math.abs(source+step+2) > (n)){
            step = 0;
            neg = steps(source - step-1,
                    step+1, dest, n);

        }

        if (source == dest)
            return step;

        if(step == 0 || step == 1)
            step = 1;
        // at each point we can go either way

        // if we go on positive side
        int pos = steps(source + step+1,
                step+1, dest, n);

        // if we go on negative side
//        int neg = steps(source - step-1,
//                step=-1  + 1, dest, n);

        // minimum of both cases
        return Math.min(pos, neg);
    }
}
