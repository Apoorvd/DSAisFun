package com.array;

public class exp {
    public static void main(String[] args) {
        int n = 10;
        int even = 0;
        long iter = 0;
        long ev = 0;
        int odd = 0;
        long od = 0;
        while( even != n )
        {
            if(Long.bitCount(iter++) == 2)
            {
                even ++;
                ev = iter-1;
            }
            if(Long.bitCount(iter++) == 3)
            {
                odd ++;
                od = iter-1;
            }
        }
        iter = 0;

        while( odd != n )
        {
            if(Long.bitCount(iter++) == 3)
            {
                odd ++;
                od = iter-1;
            }
        }

        long sumU = od + ev;
        long sumU2 = n * 2 + n * 2 - 1;

        System.out.println(sumU - sumU2);

    }
}
