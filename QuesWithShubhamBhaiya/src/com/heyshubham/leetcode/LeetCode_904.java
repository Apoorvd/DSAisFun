package com.heyshubham.leetcode;

public class LeetCode_904 {

    //https://leetcode.com/problems/fruit-into-baskets/
    public int totalFruit(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c :  tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {a = b; b = c;}
            res = Math.max(res, cur);
        }
        return res;
    }
}
/*
 public int totalFruit(int[] fruits) {
        int maximum = 0;
        int firstFruitType = -1, secondFruitType = -1;
        int nbFruits = 0, streak = 0;

        for (int i = fruits.length - 1; i >= 0; i--) {
            if(fruits[i] == firstFruitType) {
                nbFruits++;
                streak++;
            } else if(fruits[i] == secondFruitType) {
                secondFruitType = firstFruitType;
                firstFruitType = fruits[i];
                nbFruits++;
                streak = 1;
            } else {
                secondFruitType = firstFruitType;
                firstFruitType = fruits[i];
                nbFruits = streak + 1;
                streak = 1;
            }


            if(nbFruits > maximum)
                maximum = nbFruits;
        }

        return maximum;
    }
 */

/*
public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i=0,j=1,temp=0,lastPos1stEle=0,lastPos2ndEle=-1,maxLen=1;
        while(j<n){
            while(j<n && fruits[j]==fruits[i]){
                lastPos1stEle = j;
                j++;
            }
            lastPos1stEle=j-1;
            lastPos2ndEle=j;
            temp = j;
            if(j==n){
                maxLen = Math.max(maxLen,j-i);
                break;
            }
            j++;
            while(j<n && (fruits[j]==fruits[i] || fruits[j]==fruits[temp])){
                if(fruits[j]==fruits[i]){
                    lastPos1stEle = j;
                }else{
                    lastPos2ndEle=j;
                }
                j++;
            }
            maxLen = Math.max(maxLen,j-i);
            i=Math.min(lastPos1stEle,lastPos2ndEle)+1;
        }
        return maxLen;
    }
 */