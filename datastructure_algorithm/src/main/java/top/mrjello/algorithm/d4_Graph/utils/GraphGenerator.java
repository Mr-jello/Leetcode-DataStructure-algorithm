package top.mrjello.algorithm.d4_Graph.utils;

import top.mrjello.algorithm.d4_Graph.pojo.Edge;
import top.mrjello.algorithm.d4_Graph.pojo.Graph;
import top.mrjello.algorithm.d4_Graph.pojo.Node;

/**
 * 图生成器: 将二维数组转换为图
 * @author jason@mrjello.top
 * @date 2023/7/22 21:50
 */
public class GraphGenerator {

    /**
     * 二维数组转换为图
     * @param matrix 二维数组 所有的边 N*3的矩阵
     *               [from, weight, to]
     *               [from, weight, to]
     *               [from, weight, to]
     * @return 图
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer weight = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
