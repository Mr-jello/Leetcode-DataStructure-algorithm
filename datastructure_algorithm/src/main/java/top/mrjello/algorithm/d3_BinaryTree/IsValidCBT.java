package top.mrjello.algorithm.d3_BinaryTree;

import java.util.LinkedList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/21 20:47
 */
public class IsValidCBT {

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

    /**
     * 判断一棵树是否是完全二叉树
     * 1. 任意一个节点有右无左，返回false
     * 2. 一旦遇到左右孩子不双全的节点，那之后的节点必须都是叶节点，否则返回false
     * @param root 根节点
     * @return 是否是完全二叉树
     */
    public static boolean isValidCBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean isLeaf = false;
        TreeNode left = null;
        TreeNode right = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            left = root.left;
            right = root.right;

            if (
                    //当遇到第一个左右孩子不双全的节点时，isLeaf == ture，之后的节点必须都是叶节点，否则返回false
                    (isLeaf && (left != null || right != null))
                    ||
                    //任意一个节点有右无左，返回false
                    (left == null && right != null)
            )
            {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            //第一次遇到左右孩子不双全的节点，isLeaf = true
            if (left == null || right == null) {
                isLeaf = true;
            }
        }
        return true;
    }




}
