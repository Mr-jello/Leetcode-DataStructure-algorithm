package top.mrjello.leetcode; /**
Given a binary tree, determine if it is height-balanced.


 Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true


 Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false


 Example 3:


Input: root = []
Output: true



 Constraints:


 The number of nodes in the tree is in the range [0, 5000].
 -10⁴ <= Node.val <= 10⁴


 Related Topics Tree Depth-First Search Binary Tree 👍 9293 👎 528

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution110BalancedBinaryTree {
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }



    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei){
            isBalanced = isB;
            height = hei;
        }
    }

    public static ReturnType process (TreeNode x){
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
