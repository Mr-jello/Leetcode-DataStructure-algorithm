package top.mrjello.algorithm.d5_GreedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @author jason@mrjello.top
 * @date 2023/7/24 22:45
 */
public class InitialPublicOfferings {

    /**
     * 项目类
     * profit: 利润
     * cost: 成本
     */
    public static class Node {
        // 利润
        public int profit;
        // 成本
        public int cost;

        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }

    }

    /**
     * 找到最大化资本
     * @param k 最多项目数量
     * @param w 初始资金
     * @param profits 利润数组
     * @param costs 成本数组
     * @return 最终资金
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] costs) {
        // 项目数组
        Node[] nodes = new Node[profits.length];
        // 初始化项目数组
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], costs[i]);
        }

        // 花费最小堆
        PriorityQueue<Node> minCostQ= new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 利润最大堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        for (int i = 0; i < nodes.length; i++) {
            // 将项目数组中的项目按照成本放入花费最小堆
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= w) {
                // 将花费最小堆中的项目按照利润放入利润最大堆
                maxProfitQ.add(minCostQ.poll());
            }
            // 如果利润最大堆为空，直接返回当前资金
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            // 将利润最大堆中的项目利润加入资金
            w += maxProfitQ.poll().profit;
        }
        return w;
    }
}
