/* Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:

Input: ")("
Output: [""]
 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmLeft = 0, rmRight = 0;
        // Count the number of ( or ) to remove to become a valid parentheses
        for (char ch : s.toCharArray()) {
            if (ch == '(' ) {
                rmLeft++;
            } else if (ch == ')') {
                if (rmLeft != 0) {
                    rmLeft--;
                } else {
                    rmRight++;
                }
            }
        }
        // Avoid Dupl. Use Set.
        ArrayList<String> res = new ArrayList<String>();
        dfs(s, 0, res, new StringBuilder(), rmLeft, rmRight, 0, '*');
        return res;
    }

    // Open mean there is a '(' in the sb.
    // lastSkipped parameter is used to remove dupl in the resolve. Basiclly we only remove first ( or ) in a series.
    // Use StringBuilder for performance
    void dfs(String s, int i, ArrayList<String> res, StringBuilder sb, int rmL, int rmR, int open, char lastSkipped) {
        // boundary check
        if (rmL < 0 || rmR < 0 || open < 0) return;

        // Base case only no open and no rmL, rmR. Add into res
        if ( i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(i); 
        int len = sb.length();

        if (ch == '(') {
            if (rmL > 0) {
                dfs(s, i + 1, res, sb, rmL - 1, rmR, open, '('); // not use (
            }
            
            if (lastSkipped != '(') { // Only skip first  ( in a series
                dfs(s, i + 1, res, sb.append(ch), rmL, rmR, open + 1, '*'); // use (  
            }
        } else if (ch == ')') {
            if (rmR > 0) {
                dfs(s, i + 1, res, sb, rmL, rmR - 1, open, ')');	            // not use  )
            }
            
            if (open > 0 && (lastSkipped != ')')) { // Only skip first  ) in a series when there is a open
                dfs(s, i + 1, res, sb.append(ch), rmL, rmR, open - 1, '*');  	    // use )
                
            }
        } else {
            dfs(s, i + 1, res, sb.append(ch), rmL, rmR, open, '*');	// not '(' or ')' add the str.
        }
        sb.setLength(len);
    }
}