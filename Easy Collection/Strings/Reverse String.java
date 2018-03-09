/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 
*/

class Solution {
    public String reverseString(String s) {
        if(s == null || s.equals("")) return s;
        char[] arrChar = s.toCharArray();
        for (int i = 0, j = arrChar.length-1; i <= j; i++, j--) {
            char temp = arrChar[i];
            arrChar[i] = arrChar[j];
            arrChar[j] = temp;
        }
        return new String(arrChar);
    }
}