package top.mrjello.algorithm.d3_BinaryTree;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 0:07
 */
public class IsValidFBT {

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
     * 是否是满二叉树
     * 当树的高度为h时，节点数为2^h-1 == 1 << h - 1 ==> 1 * 2 ^ h - 1（左移一位相当于乘2 ）
     * @param root 根节点
     * @return 是否是满二叉树
     */
    public static boolean isValidFbtWithDynamicProgramming(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnType data = process(root);
        return data.nodes == (1 << data.height - 1);
    }

    /**
     * 统一返回信息
     */
    public static class ReturnType {
        public int height;
        public int nodes;
        public ReturnType(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    /**
     * 递归遍历整棵树
     * @param root 当前节点
     * @return 返回统一信息
     */
    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new ReturnType(height, nodes);

    }










}
