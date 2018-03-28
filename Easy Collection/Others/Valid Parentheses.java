/*
Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/
class Solution {
    public boolean isValid(String s) {
    	int length = s.length();
    	if (length % 2 == 1) return false;
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < length; i++) {
    		char cur = s.charAt(i);
            if (cur == '(') {
    			stack.push(')');
    			continue;
    		} else if (cur == '{') {
    			stack.push('}');
    			continue;
    		} else if (cur == '[') {
    			stack.push(']');
    			continue;
    		} else if (stack.isEmpty() || stack.pop() != cur) {
    			return false;
    		}
    	}
    	return stack.isEmpty();
    }
}