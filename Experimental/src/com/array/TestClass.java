package com.array;
import java.util.*;
public class TestClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();    // get the entire line after the prompt
        String[] numbers = input.split(" "); // split by spaces

        int arr[] = new int[numbers.length];

        for(int i = 0 ; i < arr.length; i++)
            arr[i] = Integer.parseInt(numbers[i]);

        System.out.println(spiderJumps(arr,arr[0]));

    }
    static int spiderJumps(int arr[],int max)
    {
        int web = 1;
        int res = 1;
        for(int i = 0; i < arr.length-1; i++)
        {
            if(arr[i+1] > arr[i])
            {
                web = web + 1;

            }
            res = res + web;
        }
        return res;
    }
    static int jumpcount(int x, int y, int n,
                         int height[])
    {
        int jumps = 0;

        for (int i = 0; i < n; i++) {
            if (height[i] <= x) {
                jumps++;
                continue;
            }

            /* If height of wall is greater than
               up move */
            int h = height[i];
            while (h > x)
            {
                jumps++;
                h = h - (x - y);
            }
            jumps++;
        }
        return jumps;
    }
}






 class GfG {
    public static int kthdigit(int a, int b, int k)
    {
        int p = (int)Math.pow(a, b);

        int count = 0;
        while (p > 0 && count < k) {
            int rem = p % 10;
            count++;
            if (count == k)
                return rem;
            p = p / 10;
        }

        return 0;
    }

    public static void main(String argc[]) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int k= sc.nextInt();
        System.out.println(kthdigit(a, b, k));
    }

}