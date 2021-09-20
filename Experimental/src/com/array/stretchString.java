package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stretchString {
    static void characterCount(String inputString,  HashMap<Character, Integer> charCountMap)
    {
        // Creating a HashMap containing char
        // as a key and occurrences as  a value

        // Converting given string to char array

        char[] strArray = inputString.toCharArray();

        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        //HashMap<Character, Integer> charCountMap = new HashMap<>();
        String s = in.readLine();
        String s2 = in.readLine();
        if(stretchy(s,s2)){
        System.out.println("Noice");}

    }
    int expressiveWords(String S, List<String> inp) {
        if (S == null || inp == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < inp.size() ; i++) {
            if (stretchy(S, inp.get(i))) {
                count++;
            }
        }
        return count;
    }
    static boolean stretchy(String S, String word) {
        if (word == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(S, i);
                int len2 = getRepeatedLength(word, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }

    static int getRepeatedLength(String str, int i) {
        int j = i;
        while (j < str.length() && str.charAt(j) == str.charAt(i)) {
            j++;
        }
        return j - i;
    }
}
