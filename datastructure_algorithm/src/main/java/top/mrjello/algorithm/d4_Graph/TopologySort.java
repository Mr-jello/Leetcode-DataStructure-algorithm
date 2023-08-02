package top.mrjello.algorithm.d4_Graph;

import top.mrjello.algorithm.d4_Graph.pojo.Graph;
import top.mrjello.algorithm.d4_Graph.pojo.Node;

import java.util.*;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 0:13
 */
public class TopologySort {
    /**
     * 拓扑排序
     * @param graph 图
     * @return 拓扑排序结果
     */
    public static List<Node> sortedTopology(Graph graph) {
        // key: 某一个node, value: 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的点,才能进入这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 遍历图中所有的点,记录其入度,并将入度为0的点放入队列
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序结果,依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            // 当前入度为0的点
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 遍历当前点的所有邻居: 相当于将其节点以及其节点的影响力(入度)减1
            for (Node next : cur.nexts) {
                // 将其节点的入度减1
                inMap.put(next, inMap.get(next) - 1);
                // 如果减1后,入度为0,则加入队列
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
