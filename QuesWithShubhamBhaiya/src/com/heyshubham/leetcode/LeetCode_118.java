package com.heyshubham.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_118 {

    //https://leetcode.com/problems/pascals-triangle/

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> row = new ArrayList();
        for(int i = 0; i < numRows; i++) {
            for(int j = row.size() - 1; j >= 1 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            res.add(new ArrayList(row));
        }
        return res;
    }
}

/*
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0)
            return triangle;
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev_row.get(j - 1) + prev_row.get(j));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
 */

/*
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> rowL = new ArrayList();
        List<Integer> pre = new ArrayList();
        int row = 1;
        while(row <= numRows){
            rowL.clear();
            for(int i = 1;i<=row;i++){
                if(i==1){
                    rowL.add(1);
                }else if(i==row){
                    rowL.add(1);
                }else{
                    rowL.add(pre.get(i-2)+pre.get(i-1));
                }
            }
            results.add(new ArrayList(rowL));
            pre = new ArrayList(rowL);
            row++;
        }
    return results;

    }
 */