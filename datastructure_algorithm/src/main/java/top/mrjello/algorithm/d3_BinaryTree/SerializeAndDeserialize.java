package top.mrjello.algorithm.d3_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 20:30
 */
public class SerializeAndDeserialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 序列化二叉树：前序遍历
     * 序列化的含义：将二叉树转换为字符串，以便于存储和传输
     * @param root 二叉树根节点
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    /**
     * 反序列化二叉树：前序遍历
     * @param data 字符串
     * @return 二叉树根节点
     */
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.offer(node);
        }
        return deserializeByPreOrder(queue);
    }

    /**
     * 反序列化二叉树：前序遍历
     * @param queue 队列
     * @return 二叉树根节点
     */
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
