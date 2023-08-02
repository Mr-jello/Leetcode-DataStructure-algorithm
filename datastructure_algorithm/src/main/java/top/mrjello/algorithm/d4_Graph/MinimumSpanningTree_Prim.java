package top.mrjello.algorithm.d4_Graph;

import top.mrjello.algorithm.d4_Graph.pojo.Edge;
import top.mrjello.algorithm.d4_Graph.pojo.Graph;
import top.mrjello.algorithm.d4_Graph.pojo.Node;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 20:58
 */
public class MinimumSpanningTree_Prim {

    /**
     * 最小生成树: 在图的基础上令各点连通，且去除了权值比较大的边，保持权值最小
     * 适用范围: 要求无向图
     * <p>
     * Prim算法:
     *          1. 首先我们任选一个顶点作为起点，然后解锁其相邻的边
     *          2. 在所有边中选权值最小的边，然后将这条边的另一个顶点解锁
     *          3. 判断其顶点是否已经解锁，若解锁则在所解锁的边中另选其权值最小的边，直到所有顶点都解锁为止
     * @param graph 图
     * @return 最小生成树的边集合
     */
    public static Set<Edge> primMst(Graph graph) {
        //解锁的边放到小根堆（优先级队列）中
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        //已解锁的点放到set中
        HashSet<Node> set = new HashSet<>();
        //最小生成树的边集合
        Set<Edge> result = new HashSet<>();
        //for循环: 解决森林问题（既有多个不相邻的图），若是连通图，则不需要for循环
        for (Node node : graph.nodes.values()) {
            //如果set中不包含node，则将node加入set中
            if (!set.contains(node)) {
                set.add(node);
                //获取node的所有边
                for (Edge edge : node.edges) {
                    //将node的所有边加入优先队列中
                    priorityQueue.add(edge);
                }
                //当优先队列不为空时
                while (!priorityQueue.isEmpty()) {
                    //弹出边edge，令toNode等于edge的出点
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    //如果set中不包含了这个出点，就加入set中，同时将边edge加入结果集result
                    //会重复加入边，但是set会去重
                    if (!set.contains(toNode)) {
                        //将出点加入set中
                        set.add(toNode);
                        result.add(edge);
                        //遍历下一个出点的所有边
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
