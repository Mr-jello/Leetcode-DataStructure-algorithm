package top.mrjello.leetcode;/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (32.41%)
 * Likes:    23279
 * Dislikes: 1358
 * Total Accepted:    2.2M
 * Total Submissions: 6.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 *
 */

// @lc code=start
public class Solution5LongestPalindromicSubstring {
        int[] range = new int[2];
        public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return s;
        }
        char[] ss = s.toCharArray();
        for (int i = 1; i < n; i++) {
            expandFromCenter(ss, n, i, i);
            expandFromCenter(ss, n, i - 1, i);
        }
        return s.substring(range[0],range[1]);
    }

    public void expandFromCenter(char[] ss, int n, int start, int end) {
        while (start >= 0 && end <= n -1){
            if (ss[start] == ss[end]) {
                start--;
                end++;
            }
        }
        if (end - (start + 1) > range[1] - range[0]){
            range[0] = start + 1;
            range[1] = end;
        }
    }
}
// @lc code=end

