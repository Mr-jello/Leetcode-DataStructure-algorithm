package top.mrjello.algorithm.d4_Graph.pojo;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 21:38
 */
public class Edge {
    //有向图的边，无向图的边是双向的
    // 边的权重
    public int weight;
    // 边的起始节点
    public Node from;
    // 边的终止节点
    public Node to;

    public Edge (int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
