/*
Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
*/


// First use divide two integers to get quotient and reminder
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	int[] res = divide(numerator, denominator);
    	int quotient = res[0].toString();
    	int reminder = res[1];
    	 if (reminder == 0) {
            return quotient.toString();
        }
        
        // fractional part
        quotient.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(reminder, quotient.length());
        while (reminder != 0) {
            reminder *= 10;
            quotient.append(reminder / den);
            reminder %= den;
            if (map.containsKey(reminder)) {
                int index = map.get(reminder);
                quotient.insert(index, "(");
                quotient.append(")");
                break;
            }
            else {
                map.put(reminder, quotient.length());
            }
        }
        return quotient.toString();
    }

    public int[] divide(int dividend, int divisor) {
        if(dividend<<1 == 0 && divisor == -1) return new int[]{Integer.MAX_VALUE, 0};
        boolean sign = (dividend > 0) ^ (divisor > 0);
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);
        return divideLong(d1, d2, sign);
    }
    public int divideLong(long dividend, long divisor, boolean sign) {       
        long res = 0;
        while (dividend >= divisor) {
            long multiple = 1;
            long temp_divisor = divisor;
            while (dividend >= (temp_divisor << 1)) {
                temp_divisor <<= 1;
                multiple <<= 1;
            }
            dividend -= temp_divisor;
            res += multiple;
        }
        return sign ? new int[]{(int) -res, (int) dividend} : new int[]{(int) res, (int) dividend} ; 
    }
}