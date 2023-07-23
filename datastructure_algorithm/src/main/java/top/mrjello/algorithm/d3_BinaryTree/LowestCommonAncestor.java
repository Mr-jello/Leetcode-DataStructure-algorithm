package top.mrjello.algorithm.d3_BinaryTree;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 0:37
 */
public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestor (TreeNode head, TreeNode o1, TreeNode o2) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = o1;
        while (cur != fatherMap.get(cur)) {
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(head);
        cur = o2;
        while (!set.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return cur;
    }

    public static void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    /**
     * 优化版: 递归遍历整棵树
     * 有两种情况：
     *          1.o1或者o2就是公共祖先 （o1在o2或者o2在o1的数上）
     *          2.o1和o2都不是公共祖先， 需要彼此向上汇聚得到公共祖先
     * @param head 头节点
     * @param o1 节点1
     * @param o2 节点2
     * @return 最近公共祖先
     */
    public static TreeNode lowestCommonAncestorOptimize(TreeNode head, TreeNode o1, TreeNode o2) {
        //如果头节点为空或者遍历到的头节点为o1或者o2，则返回头节点
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestCommonAncestorOptimize(head.left, o1, o2);
        TreeNode right = lowestCommonAncestorOptimize(head.right, o1, o2);
        //如果左右子节点不为空，返回头节点
        if (left != null && right != null) {
            return head;
        }
        //左右两棵树，并不都有返回值
        return left != null ? left : right;
    }














    @Test
    public void testLca() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.left = new TreeNode(8);

        TreeNode o1 = head.right.left;
        TreeNode o2 = head.right.right.left;
        TreeNode node = lowestCommonAncestor(head, o1, o2);
        System.out.println(node.val);
    }


}
