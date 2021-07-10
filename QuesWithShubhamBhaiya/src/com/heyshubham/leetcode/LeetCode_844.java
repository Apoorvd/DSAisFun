package com.heyshubham.leetcode;

import java.util.Stack;

public class LeetCode_844 {

    //https://leetcode.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String s, String t) {
        String sEnd = getFinalString(s);
        String tEnd = getFinalString(t);
        return sEnd.equals(tEnd);
    }

    private String getFinalString(String input) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : input.toCharArray()){
            if(c == '#'){
                if(counter > 0){
                    counter--;
                    sb.deleteCharAt(counter); // O(1) since it's the last index
                }
            } else {
                sb.append(c);
                counter++;
            }
        }
        return sb.toString();
    }
    /*
    public boolean backspaceCompare(String s, String t) // 2ms solution using stack
    {
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();

        for(char c:s.toCharArray()){
            if(c == '#' && !stackOne.isEmpty()){
                stackOne.pop();
            }else if(c != '#'){
                stackOne.push(c);
            }
        }

        for(char c:t.toCharArray()){
            if(c == '#' && !stackTwo.isEmpty()){
                stackTwo.pop();
            }else if(c != '#'){
                stackTwo.push(c);
            }
        }

        if(stackOne.isEmpty() && stackTwo.isEmpty()){
            return true;
        }

        while(!stackOne.isEmpty() && !stackTwo.isEmpty()){
            if(stackOne.pop() != stackTwo.pop()){
                return false;
            }
        }

        if(stackOne.size() > stackTwo.size() || stackOne.size() < stackTwo.size()){
            return false;
        }

        return true;

    }

     */

    /*
    two pointer problem
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
     */


}
