package top.mrjello.leetcode; /**
Given the root of a binary tree, determine if it is a valid binary search tree (
BST).

 A valid BST is defined as follows:


 The left subtree of a node contains only nodes with keys less than the node's
key.
 The right subtree of a node contains only nodes with keys greater than the
node's key.
 Both the left and right subtrees must also be binary search trees.



 Example 1:


Input: root = [2,1,3]
Output: true


 Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -2³¹ <= Node.val <= 2³¹ - 1


 Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 15048
👎 1222

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
public class Solution98ValidateBinarySearchTree {
    public static class TreeNode {
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


    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma){
            isBST = is;
            min = mi;
            max = ma;
        }
    }
    public static ReturnData process(TreeNode x){
        if (x == null) {
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        int min = x.val;
        int max = x.val;
        if (leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isBST = false;
        if (
                (leftData != null ? (leftData.isBST && leftData.max < x.val) : true)
                        &&
                        (rightData != null ? (rightData.isBST && rightData.min > x.val) : true)
        ){
            isBST = true;
        }
        return new ReturnData(isBST, min, max);
    }
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
