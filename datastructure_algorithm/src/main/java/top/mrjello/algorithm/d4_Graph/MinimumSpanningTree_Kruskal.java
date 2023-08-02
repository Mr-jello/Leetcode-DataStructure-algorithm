package top.mrjello.algorithm.d4_Graph;

import top.mrjello.algorithm.d4_Graph.pojo.Edge;
import top.mrjello.algorithm.d4_Graph.pojo.Graph;
import top.mrjello.algorithm.d4_Graph.utils.UnionFind;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 19:52
 */
public class MinimumSpanningTree_Kruskal {

    /**
     * 最小生成树: 在图的基础上令各点连通，且去除了权值比较大的边，保持权值最小
     * 适用范围: 要求无向图
     * <p>
     * Kruskal算法:
     *     1. 首先我们把所有的边按照权值先从小到大排列
     *     2. 接着按照顺序选取每条边，如果这条边的两个端点不属于同一集合，那么就将它们合并，直到所有的点都属于同一个集合为止。
     */

    public static Set<Edge> kruskalMst(Graph graph) {
        //初始化UnionFind
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());

        //初始化最小生成树
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        //当优先队列不为空，弹出边
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            //判断边的入点和出点是否在相同集合中
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }


}
