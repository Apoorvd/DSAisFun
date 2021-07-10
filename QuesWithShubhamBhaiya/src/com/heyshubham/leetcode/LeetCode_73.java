package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class LeetCode_73 {

    //https://leetcode.com/problems/set-matrix-zeroes/

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> hash_i = new HashSet<>();
        HashSet<Integer> hash_j = new HashSet<>();
        int numOfColumns = matrix[0].length;
        int numOfRows = matrix.length;
        int i,j;
        for(i = 0; i < numOfRows; i++)
        {
            for(j = 0; j < numOfColumns; j++ )
            {
                if(matrix[i][j] == 0)
                {
                    hash_i.add(i);
                    hash_j.add(j);
                }
            }
        }

        //
        for(i = 0; i < numOfRows; i++)
        {
            for(j = 0; j < numOfColumns; j++ )
            {
                if(hash_i.contains(i) || hash_j.contains(j))
                    matrix[i][j]=0;
            }
        }

    }
//    Neeche vala Chapa hua Solution hai.. Baad me time leke smjhenge

    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (isCol) {
                matrix[i][0] = 0;
            }
        }
    }

    // 1ms
    public void setZeroes3(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        ArrayList<Integer> rs = new ArrayList<>();
        ArrayList<Integer> cs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rs.add(i);
                    cs.add(j);
                }
            }
        }

        for (int r : rs) {
            for (int i = 0; i < n; i++) mat[r][i] = 0;
        }

        for (int c : cs) {
            for (int i = 0; i < m; i++) mat[i][c] = 0;
        }
    }

    //0 ms
    public void setZeroes4(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowZero = false;
        boolean colZero = false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if(i == 0){
                        rowZero = true;
                    }
                    if(j == 0){
                        colZero = true;
                    }
                }
            }
        }

        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if((matrix[0][j] == 0 && (j != 0 || colZero)) || (matrix[i][0] == 0 && (i != 0 || rowZero))){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


/*
2ms
public void setZeroes(int[][] matrix) {
        int col = 1;

        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                col = 0;
            }
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col == 0){
                matrix[i][0] = 0;
            }
        }
    }
 */

/*
3ms

int r,c,dim;
    public Pos(int i, int j,int dim){
        this.r = i;
        this.c = j;
        this.dim = dim;
    }
}
class Solution{
    public void setZeroes(int[][] matrix){
        int col_0 = 1;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0]==0) col_0 = 0;
               for(int j=1; j<matrix[0].length; j++){
                   if(matrix[i][j]==0) {
                       matrix[i][0]=0;
                       matrix[0][j]=0;
                   }
               }
        }
        for(int i=matrix.length-1; i>=0; i--) {
               for(int j=matrix[0].length-1; j>=1; j--){
                   if(matrix[i][0]==0||matrix[0][j]==0) matrix[i][j]=0;
               }
               if(col_0==0) matrix[i][0]=0;
        }
    }
}

class bfs {
    // bfs solution
    public void setZeroes(int[][] matrix) {
         Queue<Pos> queue = new LinkedList();
         for(int i=0; i<matrix.length; i++){
             for(int j=0; j<matrix[0].length; j++){
                 if(matrix[i][j]==0) {
                     queue.offer(new Pos(i,j,4));
                 }
             }
         }
         int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i=0; i<size; i++){
                 Pos pos = (Pos)queue.poll();
                 if(pos.dim==4) {
                     for(int j=0; j<4; j++){
                        int r = pos.r+dir[j][0];
                        int c = pos.c+dir[j][1];
                        if(r>=0&&c>=0&&r<matrix.length&&c<matrix[0].length){
                           matrix[r][c]=0;
                           queue.offer(new Pos(r,c,j));
                        }
                     }
                 }
                 else {
                        int r = pos.r+dir[pos.dim][0];
                        int c = pos.c+dir[pos.dim][1];
                        if(r>=0&&c>=0&&r<matrix.length&&c<matrix[0].length){
                           matrix[r][c]=0;
                           queue.offer(new Pos(r,c,pos.dim));
                        }
                 }
             }
         }
    }
 */