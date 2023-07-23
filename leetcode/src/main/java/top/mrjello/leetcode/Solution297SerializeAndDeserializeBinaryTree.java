package top.mrjello.leetcode; /**
Serialization is the process of converting a data structure or object into a
sequence of bits so that it can be stored in a file or memory buffer, or
transmitted across a network connection link to be reconstructed later in the same or
another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no
restriction on how your serialization/deserialization algorithm should work. You
just need to ensure that a binary tree can be serialized to a string and this
string can be deserialized to the original tree structure.

 Clarification: The input/output format is the same as how LeetCode serializes
a binary tree. You do not necessarily need to follow this format, so please be
creative and come up with different approaches yourself.


 Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]


 Example 2:


Input: root = []
Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 10⁴].
 -1000 <= Node.val <= 1000


 Related Topics String Tree Depth-First Search Breadth-First Search Design
Binary Tree 👍 9203 👎 336

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * @author Jason
 */
public class Solution297SerializeAndDeserializeBinaryTree {

   public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }




    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.offer(node);
        }
        return deserializeByPreOrder(queue);
    }

    public static TreeNode deserializeByPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeByPreOrder(queue);
        root.right = deserializeByPreOrder(queue);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
