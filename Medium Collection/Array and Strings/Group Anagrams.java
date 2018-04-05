/*
Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
    	for (String s: strs) {
    		String sortS = sortString(s);
    		if (hm.containsKey(sortS)) {
            	hm.get(sortS).add(s);
    		} else {
    			ArrayList<String> list = new ArrayList<String>();
    			list.add(s);
    			hm.put(sortS, list);
    		}
    	}
    	return new ArrayList(hm.values());
    }

    public String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}