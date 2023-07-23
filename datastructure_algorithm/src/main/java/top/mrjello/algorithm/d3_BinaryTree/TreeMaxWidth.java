package top.mrjello.algorithm.d3_BinaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jason@mrjello.top
 * @date 2023/7/21 18:02
 */
public class TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int treeMaxWidth(Node root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int level = 0;
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                Node node = queue.poll();
                res.get(level).add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                maxWidth = Math.max(maxWidth, res.get(level).size());
            }
            level++;
        }
        return maxWidth;
    }




    @Test
    public void testMaxWidth() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println(treeMaxWidth(root));
    }
}
