/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings. 
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs==null||strs.length==0) return res;
        // find the smallest length
        int slen = strs[0].length();
        int idxRes = 0;
        for(int i=0; i<strs.length; i++){
            if(slen>strs[i].length()){
                slen = strs[i].length();
                idxRes = i;
            }
        }
        for(int i=0; i<slen; i++){
            char c = strs[0].charAt(i);
            for(String str:strs){
                if(str.charAt(i)!=c) return strs[0].substring(0,i);
            }
        }
        return strs[idxRes];
        
    }
}