package top.mrjello.leetcode;

import java.util.Stack;

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

 An input string is valid if:


 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.



 Example 1:


Input: s = "()"
Output: true


 Example 2:


Input: s = "()[]{}"
Output: true


 Example 3:


Input: s = "(]"
Output: false



 Constraints:


 1 <= s.length <= 10⁴
 s consists of parentheses only '()[]{}'.


 Related Topics String Stack 👍 20836 👎 1308

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution20ValidParentheses{
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // push open brackets
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (c == ')' && open != '(') {
                    return false;
                }
                if (c == '}' && open != '{') {
                    return false;
                }
                if (c == ']' && open != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
