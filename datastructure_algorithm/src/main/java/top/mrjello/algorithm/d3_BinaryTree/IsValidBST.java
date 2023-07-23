package top.mrjello.algorithm.d3_BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jason@mrjello.top
 * @date 2023/7/21 18:56
 */
public class IsValidBST {

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
     * 判断一棵树是否是二叉搜索树
     * 使用中序遍历，判断是否是升序（左头右）
     */
    public long min = Long.MIN_VALUE;
    public boolean isValidBstWithRecursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean validBST = isValidBstWithRecursion(root.left);
        if (!validBST) {
            return false;
        }
        if (root.val <= min) {
            return false;
        }
        min = root.val;
        return isValidBstWithRecursion(root.right);
    }

    public boolean isValidBstEasyWay(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> inOrderList = new LinkedList<>();
        process(root, inOrderList);
        int pre = Integer.MIN_VALUE;
        for (TreeNode node : inOrderList) {
            if (pre >= node.val) {
                return false;
            }
            pre = node.val;
        }
        return true;
    }

    public void process(TreeNode root, LinkedList<TreeNode> inOrderList) {
        if (root == null) {
            return;
        }
        process(root.left, inOrderList);
        inOrderList.add(root);
        process(root.right, inOrderList);
    }


    /**
     * 判断一棵树是否是二叉搜索树
     * 使用中序遍历，判断是否是升序（左头右）
     * 使用栈
     */
    public static boolean isValidBstWithStack(TreeNode root) {

        if (root != null) {
            int pre = Integer.MIN_VALUE;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.add(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    if (root.val <= pre) {
                        return false;
                    }else {
                        pre = root.val;
                    }
                    root = root.right;
                }
            }
        }
        return true;
    }

    /**
     * 判断一棵树是否是二叉搜索树
     * 使用动态规划：
     *          1. 左数为二叉搜索树，右数也为二叉搜索树
     *          2. 左数的最大值小于当前节点
     *          3.右数的最小值大于当前节点
     * @param root 根节点
     * @return 是否是二叉搜索树
     */
    public static boolean isValidBstWithDynamicProgramming(TreeNode root) {

        return process(root).isBst;
    }

    /**
     * 统一返回信息
     */
    public static class ReturnData {
        public boolean isBst;
        public int min;
        public int max;
        public ReturnData(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 递归遍历整棵树
     * @param root 根节点
     * @return 返回统一信息
     */
    public static ReturnData process(TreeNode root) {
        if (root == null) {
            return null;
        }
        //递归遍历整棵树，获取统一信息
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int min = root.val;
        int max = root.val;
        //当左右节点不为空时，获取左右节点的最大值和最小值
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        //判断当前节点是否是二叉搜索树
        boolean isBst = true;
        //左数不为空，且左数不是二叉搜索树，或者左数的最大值大于当前节点，当前节点不是二叉搜索树
        if (leftData != null && (leftData.isBst || leftData.max >= root.val)) {
            isBst = false;
        }
        //右数不为空，且右数不是二叉搜索树，或者右数的最小值小于当前节点，当前节点不是二叉搜索树
        if (rightData != null && (rightData.isBst || rightData.min <= root.val)) {
            isBst = false;
        }

//第二种写法
//        boolean isBST = false;
//        if (
//                (leftData != null ? (leftData.isBST && leftData.max < x.val) : true)
//                        &&
//                (rightData != null ? (rightData.isBST && rightData.min > x.val) : true)
//        )
//        {
//            isBST = true;
//        }

        return new ReturnData(isBst, min, max);
    }

}
