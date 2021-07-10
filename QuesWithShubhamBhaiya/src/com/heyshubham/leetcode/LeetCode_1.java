package com.heyshubham.leetcode;

import java.util.HashMap;

public class LeetCode_1 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();

            int i=0,j=numbers.length-1;
            while(i<=numbers.length/2)
            {
                int remain=target-numbers[i];
                if(h.containsKey(remain))
                {
                    return new int[]{h.get(remain), i};
                }
                h.put(numbers[i],i);
                i++;
                remain=target-numbers[j];
                if(h.containsKey(remain))
                {
                    return new int[]{ h.get(remain), j};
                }
                h.put(numbers[j],j);
                j--;
            }
            return null;

        }
    }
    /*
    public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
}
     */
}
