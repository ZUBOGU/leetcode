/*
Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
class Solution {
    public int romanToInt(String s) {
    	int ret = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	if (c == 'M') {
        		ret += 1000;
        	}
        	if (c == 'C' && i < arr.length - 1 && arr[i+1] == 'M') {
        		ret -= 100;
                continue;
        	}
        	if (c == 'D') {
        		ret += 500;
        	}
        	if (c == 'C' && i < arr.length - 1 && arr[i+1] == 'D') {
        		ret -= 100;
                continue;
        	}
        	if (c == 'C') {
        		ret += 100;
        	}
            if (c == 'X' && i < arr.length - 1 && arr[i+1] == 'C') {
        		ret -= 10;
                continue;
        	}        	
            if (c == 'L') {
        		ret += 50;
        	}
        	if (c == 'X' && i < arr.length - 1 && arr[i+1] == 'L') {
        		ret -= 10;
                continue;
        	}        	
            if (c == 'X') {
        		ret += 10;
        	}
        	if (c == 'I' && i < arr.length - 1 && arr[i+1] == 'X') {
        		ret -= 1;
                continue;
        	}        	
            if (c == 'V') {
        		ret += 5;
        	} 
        	if (c == 'I' && i < arr.length - 1 && arr[i+1] == 'V') {
        		ret -= 1;
                continue;
        	}        	
            if (c == 'I') {
        		ret += 1;
        	}    	
        }
        return ret;
    }
}