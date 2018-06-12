/* Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

class Solution {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    
    public List<List<String>> partition(String s) {
      resultLst = new ArrayList<>();
      currLst = new ArrayList<>();
      backTracking(s, 0);
      return resultLst;
    }
    
    // DFS
    public void backTracking(String s, int l) {
      // Base case. end of string add to resultList.
      if (currLst.size() > 0 && l >= s.length()) {
        List<String> r = (ArrayList<String>) currLst.clone();
        resultLst.add(r);
      }

      for (int i = l; i < s.length(); i++) {
        if (isPalindrome(s, l, i)) {
          if (l == i) {
            currLst.add(String.valueOf(s.charAt(i)));
          } else {
            currLst.add(s.substring(l,i+1));
          }
          // recursive to deep
          backTracking(s,i+1);
          // clean the currLst after done with current "i"
          currLst.remove(currLst.size() -1 );
        }
      }

    }

    // help method check if it is palindrome str at index l to r.
    public boolean isPalindrome(String str, int l, int r){
      if(l==r) return true;
      while(l<r){
          if(str.charAt(l)!=str.charAt(r)) return false;
          l++;r--;
      }
      return true;
  }
}