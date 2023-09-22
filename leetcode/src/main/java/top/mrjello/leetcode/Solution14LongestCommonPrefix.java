package top.mrjello.leetcode;

/**
Write a function to find the longest common prefix string amongst an array of
strings.

 If there is no common prefix, return an empty string "".


 Example 1:


Input: strs = ["flower","flow","flight"]
Output: "fl"


 Example 2:


Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.



 Constraints:


 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lowercase English letters.


 Related Topics String Trie 👍 15854 👎 4211

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); // 以第一个字符串为基准
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

}
//leetcode submit region end(Prohibit modification and deletion)
