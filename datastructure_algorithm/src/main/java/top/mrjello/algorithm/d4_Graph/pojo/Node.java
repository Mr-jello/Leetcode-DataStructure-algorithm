package top.mrjello.algorithm.d4_Graph.pojo;

import java.util.ArrayList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 21:37
 */
public class Node {

    // 节点值
    public int value;
    // 入度
    public int in;
    // 出度
    public int out;
    // 从该节点出发的下一节点,由它发散出去的边直接指向的节点
    public ArrayList<Node> nexts;
    // 从该节点出发的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
