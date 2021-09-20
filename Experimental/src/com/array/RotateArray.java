package com.array;

import java.util.Scanner;

public class RotateArray {
    /*Function to left rotate arr[] of size n by d*/
    static void leftRotate(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    static void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[n-1] = temp;
    }

    /* utility function to print an array */
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
//        String input = sc.nextLine();    // get the entire line after the prompt
//        String[] numbers = input.split(" "); // split by spaces

        int arr[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        int d = sc.nextInt();
        leftRotate(arr,d,n);
        printArray(arr,n);

    }
}