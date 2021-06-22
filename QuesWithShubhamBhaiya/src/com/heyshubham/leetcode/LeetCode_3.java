package com.heyshubham.leetcode;

import java.util.HashMap;

public class LeetCode_3 {


    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character,Integer> substring=new HashMap<>();
            int right, left = 0, max = 0;
            for(right = 0; right < s.length(); right++) {
                if(substring.containsKey(s.charAt(right))) {
                    max = Math.max(max, right - left);
                    left =  Math.max(left,substring.get(s.charAt(right))+1);
                }
                substring.put(s.charAt(right), right);
            }
            return Math.max(max, right - left);
        }
    }// T.C O(n)
// S.C O(n)


