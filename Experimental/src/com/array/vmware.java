package com.array;

public class vmware {
    public static void main(String[] args) {

        int a[][]={{1,2,3,4},
                {4,4,4,4},
                {5,5,1,1},
                {1,3,5,4},
                {1,2,1,1}};
        int m = a.length;
        int n = a[0].length;
        int sumI=0;
        int sumJ=0;
        for(int i = 0; i < m-3; i++)
        {
            for(int j = 0; j < n-3; j++) {
                sumI = Math.max(sumI, pwrI(a, i, j));
                sumJ = Math.max(sumJ, pwrJ(a, i, j));
            }
        }
        System.out.println(Math.abs(sumI-sumJ));// mc bc cc ques kyu galat read kiya tera dimaag ko repairing ki zaroorat hai.. or concetration ki.. ye aise hone ka nhi kuch vrna
    }
    static int pwrI(int[][] a, int startI,int startJ)
    {
        int sum = 0;
        for(int i =startJ; i < startJ+3; i++)
            sum = sum + a[startI][i] + a[startI+2][i];
        sum = sum + a[startI+1][startJ+1];
        return sum;
    }
    static int pwrJ(int[][] a, int startI,int startJ)
    {
        if(startI + 4 > a.length)
            return 0;
        int sum = 0;
        for(int i =startJ; i < startJ+3; i++)
            sum = sum + a[startI][i] ;
        sum = sum + a[startI+1][startJ+1] + a[startI+2][startJ+1] + a[startI+3][startJ+1];
        return sum;
    }
}
