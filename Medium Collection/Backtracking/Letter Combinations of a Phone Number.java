/*
Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

*/

class Solution {
	String[][] refer = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (!digits.equals("")) {
        	helper(ret, digits, "");
        }
        return ret;
    }

    public void helper( List<String> list, String digits, String s) {
    	if (digits.length() == 0) {
    		list.add(s);
            return;
    	}
    	int index = Integer.parseInt(digits.substring(0, 1));
    	for (String c : refer[index]) {
    		helper(list, digits.substring(1, digits.length()), s + c);
    	}

    }
}