package com.heyshubham.leetcode;

public class LeetCode_8 {

    //https://leetcode.com/problems/string-to-integer-atoi/\

    public int myAtoi(String str) // 1 ms solution
    {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(index < str.length() && str.charAt(index) == ' ' )
            index ++;

        //3. Handle signs
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    /*
    1 ms solution
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        String temp = s.trim();

        if (temp.length() == 0) {
            return 0;
        }

        Boolean isPositive = true;

        int i = 0;
        if (temp.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (temp.charAt(i) == '+') {
            i++;
        }

        double result = 0;

        while(temp.length() > i && temp.charAt(i) >= '0' && temp.charAt(i) <= '9') {
            result = result * 10 + (temp.charAt(i) - '0');
            i++;
        }

        if (!isPositive) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
     */

    /*
    2ms solution
    public int myAtoi(String s) {

        String str = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int i = 0;

        boolean isPositive = str.startsWith("+");
        boolean isNegative = str.startsWith("-");

        if (isNegative)
            i++;
        if (isPositive)
            i++;

        double number = 0;

        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //System.out.println((int)s.charAt(i));
            number = (number * 10) + (str.charAt(i) - '0');
            i++;
        }

        if (isNegative)
            number = number * -1;

        if (number < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (number > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) number;
    }
     */

    /*
    3 ms solution
    class Solution {

    Psudecode:
    1. leading white space ignored
    2. check next c, either '-' '+' isdigal are valid, otherwise return 0, sign=+-/1
    3. create a hashMap table num['0'-'9']=0-9
    4. while loop till next c is not digital anymore
        if sign>0 and ret > (Integer.MAX_VALUE-num[c])/10 return Integer.MAX_VALUE
        if sign<0 and ret > (Integer.MAX_VALUE+1-num[c])/10 return Integer.MIN_VALUE
        ret = num[c]+ret*10
    return ret*sign

    Time complexity: o(n) n is the s.length()
    Space complexity: o(1)


    public int myAtoi(String s) {
        int sign=1;
        int ret=0;
        boolean start=true;
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> nums = new HashMap<>();
        nums.put('0',0);
        nums.put('1',1);
        nums.put('2',2);
        nums.put('3',3);
        nums.put('4',4);
        nums.put('5',5);
        nums.put('6',6);
        nums.put('7',7);
        nums.put('8',8);
        nums.put('9',9);

        for(char c: s.toCharArray()){
            if(start){
                if(c == ' ')continue; // leading 0

                if(c== '-'){
                    sign=-1;
                    start=false;
                    continue;
                }
                if(c== '+'){
                    start=false;
                    continue;
                }
                if(!Character.isDigit(c)){
                    return 0; // not start with dignal or sign
                }else{
                    start=false;
                    ret=nums.get(c);
                }
            }else{

                if(!Character.isDigit(c)){
                    return ret*sign;
                }
                if(Character.isDigit(c)){
                    if(sign>0 &&  ret > (Integer.MAX_VALUE-nums.get(c))/10) return Integer.MAX_VALUE;
                    if(sign<0 &&  ret > (Integer.MAX_VALUE-nums.get(c))/10) return Integer.MIN_VALUE;
                    ret=ret*10+nums.get(c);
                }
            }
        }

        return ret*sign;


    }
     */

    /*

    Minimum space solution

    public int myAtoi(String s) {
        if(s==null||s.isBlank()) return 0;
        boolean neg = false;
        int i=0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(s.charAt(i)=='-'){
            neg = true;
            i++;
        }else if(s.charAt(i)=='+'){
            neg = false;
            i++;
        }
        long result = 0;
        long intMax = Integer.MAX_VALUE;
        long intMin = Integer.MIN_VALUE;
        while(i<s.length() && Character.isDigit(s.charAt(i)) ){
            Character ic = s.charAt(i);
            result *= 10;
            result += ic-'0';
            i++;
            if((neg==true && result>intMax+1) || (neg==false && result>intMax)){
                break;
            }
        }
        System.out.println(result);
        return (int)(neg ? (result>intMax+1 ? intMin : -1*result)
                    : (result>intMax ? intMax : result));
    }
     */
    /* 2ms nice  solution
    public int myAtoi(String str) {
  if (str == null || str.length() == 0)
		return 0;//
	str = str.trim();
       if (str.equals("")) return 0;
	char firstChar = str.charAt(0);
	int sign = 1, start = 0, len = str.length();
	long sum = 0;
	if (firstChar == '+') {
		sign = 1;
		start++;
	} else if (firstChar == '-') {
		sign = -1;
		start++;
	}
	for (int i = start; i < len; i++) {
		if (!Character.isDigit(str.charAt(i)))
			return (int) sum * sign;
		sum = sum * 10 + str.charAt(i) - '0';
		if (sign == 1 && sum > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	}

	return (int) sum * sign;
}
     */
}
