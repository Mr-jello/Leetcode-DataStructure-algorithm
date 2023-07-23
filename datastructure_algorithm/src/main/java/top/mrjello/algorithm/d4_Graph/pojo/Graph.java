package top.mrjello.algorithm.d4_Graph.pojo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 21:35
 */
public class Graph {
    // 节点集合: 点集
    public HashMap<Integer, Node> nodes;
    // 边集合: 边集
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
