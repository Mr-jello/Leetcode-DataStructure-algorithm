package top.mrjello.algorithm.d4_Graph;

import top.mrjello.algorithm.d4_Graph.pojo.Edge;
import top.mrjello.algorithm.d4_Graph.pojo.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 21:53
 */
public class Dijkstra {

    /**
     * 迪杰斯特拉：从head出发到所有点的最小距离
     * HashMap<Node, Integer>
     *              1. key:从head出发到达key
     *              2. value:从head出发到key的最小距离
     * @param head 头节点
     * @return HashMap<Node, Integer>
     */
    public static HashMap<Node, Integer> dijkstra(Node head) {
        // 从head出发到所有点的最小距离,如果没有记录，含义使从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // 从head出发到head的距离为0
        distanceMap.put(head, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        // 从distanceMap中获取距离head最近且不在selectedNodes里的一条记录
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        // 当minNode不为空
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            // 遍历minNode的所有边
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                // 如果本来是没有路，现在有路了，就录入这条路，否则本来有路就取更小的路
                if (!distanceMap.containsKey(toNode)) {
                    // 原本A到B的距离是正无穷，现在B的值是distance到边的权值
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    // toNode的之前到点的距离和现在进行比较取最小值放入distanceMap
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            // 将minNode加入selectedNodes
            selectedNodes.add(minNode);
            // 从distanceMap中获取距离head最近且不在selectedNodes里的一条记录
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        // 赋值为无穷大，再逐步用短距离替换
        Node minNode = null;
        //最小距离
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            // 节点
            Node node = entry.getKey();
            // 距离
            int distance = entry.getValue();
            // 如果该节点还未计算过并且距离小于minDistance
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }





    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {

        private Node[] nodes;
        //nodes记录堆的位置？如果-1表示曾经进来过
        private HashMap<Node, Integer> heapIndexMap;
        private HashMap<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            //如果node在heap中，和原先distanceMap对比取小值存入
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            //如果node未加入heapIndexMap中，
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            //交换0和size-1的位置
            swap(0, size - 1);
            //将原本头节点的位置的heapIndexMap对应value设置为-1
            heapIndexMap.put(nodes[size - 1], -1);
            //distanceMap移除该记录
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            //新的节点被交换至头节点位置

            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        //判断某个node是否在Heap中，
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        //数组在堆上的位置交换节点
        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    //迪杰斯特拉算法优化
    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }






}
