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
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // get the sign
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        // Use long to avoid overflow.
        long d1 = Math.abs((long) numerator);
        long d2 = Math.abs((long) denominator);

        // Integral part
        res.append(d1 / d2);
        long reminder = d1 % d2;
        if (reminder == 0) return res.toString();

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while( reminder != 0) {
            map.put(reminder, res.length());

            reminder *= 10;
            res.append(reminder / d2);
            reminder %= d2;

            Integer index = map.get(reminder);
            if (index != null) {
                res.insert(index, "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
}