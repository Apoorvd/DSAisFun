package com.heyshubham.leetcode;

public class LeetCode_125 {

    //https://leetcode.com/problems/valid-palindrome/

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() -1 ;
        while (start < end) {

            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if(!isAlphaNumeric(startChar)) {
                start++;
                continue;
            }

            if(!isAlphaNumeric(endChar)) {
                end--;
                continue;
            }

            if(toUpperCase(startChar) != toUpperCase(endChar)) {
                return false;
            }

            start++;
            end--;

        }
        return true;


    }
    public boolean isAlphaNumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a'  && c <= 'z');
    }

    public char toUpperCase(char c) {
        return   (c >= 'a' && c <= 'z') ? (char) (c - 32) : c;
    }
}
