package top.mrjello.algorithm.d3_BinaryTree;

/**
 * @author jason@mrjello.top
 * @date 2023/7/21 21:43
 */
public class IsValidBBT {

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
     * 判断一棵树是否是平衡二叉树: 任意节点的左右子树高度差不超过1
     * 动态规划思想：从左右获取相应的统一信息
     *          1. 左数为平衡二叉树，右数也为平衡二叉树
     *          2. 左右两棵树高度差不超过1
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public static boolean isValidBBT(TreeNode root) {
        return process(root).isBalanced;
    }

    /**
     * 左右两树获取的统一信息
     */
    public static class ReturnType {
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }

    }

    /**
     * 递归遍历整棵树
     * @param root 根节点
     * @return 返回统一信息
     */
    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        //递归遍历整棵树，获取树的最高值
        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);
        //获取当前节点的高度：左右两树最高的高度+1
        int height = Math.max(leftData.height, rightData.height) + 1;
        //判断当前节点是否平衡：左右两树是否平衡 && 左右两树高度差不超过1
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        //返回当前节点的统一信息
        return new ReturnType(true, height);
    }





}
