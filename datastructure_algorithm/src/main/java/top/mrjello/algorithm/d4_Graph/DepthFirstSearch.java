package top.mrjello.algorithm.d4_Graph;

import top.mrjello.algorithm.d4_Graph.pojo.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 23:47
 */
public class DepthFirstSearch {
    /**
     * 深度优先遍历
     * @param node 节点
     */
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            // 从左到右遍历当前节点的所有邻居节点
            for (Node next : cur.nexts) {
                // 如果当前邻居节点没有被访问过
                if (!set.contains(next)) {
                    // 将当前节点和当前邻居节点入栈
                    stack.push(cur);
                    stack.push(next);
                    // 将当前邻居节点标记为已访问
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }



}
