package com.heyshubham.leetcode;

public class LeetCode_48 {

    // https://leetcode.com/problems/rotate-image/

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

/* Using recursion
public void rotate(int[][] matrix) {
        int n=matrix.length;
        int step=n-1;
        for(int i=0;i<n/2;i++) {
			for(int j=i;j<n-i-1;j++) {
				recursol(i, j, j-i, step-j-i, matrix, matrix[i][j], 0);
			}
		}
    }
    void recursol(int x,int y,int stepx,int stepy,int[][]matrix,int num,int count){
        if(count<4) {
    		//System.out.printf("(%d,%d)\n",x+1,y+1);
    		x+=stepx;
    		y+=stepy;
    		int tmp=matrix[x][y];
        	matrix[x][y]=num;
        	recursol(x,y,stepy,-stepx,matrix,tmp,count+1);
    	}

 */

/* different way
public void rotate(int[][] matrix) {
        if(matrix.length==1)return ;


        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j]= matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }
 */