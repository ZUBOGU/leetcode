/*Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

// Stack
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
        	if (token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
        		String op2 = s.pop();
        		String op1 = s.pop();
        		String res = calculate(op1, op2, token);
        		s.push(res);
        	} else {
        		s.push(token);
        	}
        }
        return Integer.parseInt(s.pop());
    }

    public String calculate(String op1, String op2, String op) {
    	int one = Integer.parseInt(op1);
    	int two = Integer.parseInt(op2);
        String res = "";
    	if (op.equals("+")) res = String.valueOf(one + two);
        if (op.equals("-")) res = String.valueOf(one - two);
        if (op.equals("*")) res = String.valueOf(one * two);
        if (op.equals("/")) res = String.valueOf(one / two);
        return res;
    }
}