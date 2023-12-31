package top.mrjello.leetcode; /**
Given the root of a binary tree, return the level order traversal of its nodes'
values. (i.e., from left to right, level by level).


 Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]


 Example 2:


Input: root = [1]
Output: [[1]]


 Example 3:


Input: root = []
Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000


 Related Topics Tree Breadth-First Search Binary Tree 👍 13720 👎 271

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * @author Jason
 */
public class Solution102BinaryTreeLevelOrderTraversal {

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


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                res.get(level).add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
