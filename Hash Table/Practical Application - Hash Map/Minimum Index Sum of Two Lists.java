/* Minimum Index Sum of Two Lists
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists. */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            hm1.put(list1[i], i);
        }
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
        for (int j = 0; j < list2.length; j++) {
            if (hm1.containsKey(list2[j])) {
                hm2.put(list2[j], j + hm1.get(list2[j]));
            }
        }
        int min = Collections.min(hm2.values());
        List<String> ls = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry: hm2.entrySet()) {
            if (entry.getValue() == min) {
                ls.add(entry.getKey());
            }
        }
        String[] ret = new String[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            ret[i] = ls.get(i);
        }
        return ret;
    }
}