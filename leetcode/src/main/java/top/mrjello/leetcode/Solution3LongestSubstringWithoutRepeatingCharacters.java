package top.mrjello.leetcode;/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.80%)
 * Likes:    31194
 * Dislikes: 1357
 * Total Accepted:    4.1M
 * Total Submissions: 12.3M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
public class Solution3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                left = Math.max(left, map.get(r) + 1);
            }
            map.put(r, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
// @lc code=end

