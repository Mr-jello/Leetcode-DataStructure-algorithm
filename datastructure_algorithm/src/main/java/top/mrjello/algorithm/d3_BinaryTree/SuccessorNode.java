package top.mrjello.algorithm.d3_BinaryTree;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 19:51
 */
public class SuccessorNode {

    /**
     * 获取某个节点的后继节点：中序遍历的下一个节点就是后继节点
     * 该节点比较特殊，记录了父节点的信息
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 获取某个节点的后继节点
     * @param node 节点
     * @return 后继节点
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        //1. 如果该节点有右子树，那么后继节点就是右子树的最左节点
        if (node.right != null) {
            return getLeftMost(node.right);
        }else {
            //2. 如果该节点没有右子树。后继节点为第一个有左子树的父节点
            Node parent = node.parent;
            //如果父节点不为空且父节点的左子节点不为当前节点，获取当前节点的父节点
            //1. 父节点为空，说明该节点为最深右节点，没有后继节点
            //2. 父节点的左子节点为当前节点，说明该节点为父节点的左子节点，父节点就是后继节点
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 获取某个节点的最深左节点
     * @param node 节点
     * @return 最深左节点
     */
    public static Node getLeftMost(Node node) {
        //如果节点为空，返回该节点
        if (node == null) {
            return node;
        }
        //查询该节点的最深左节点
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
