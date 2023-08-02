package top.mrjello.algorithm.d4_Graph.utils;

import top.mrjello.algorithm.d4_Graph.pojo.Node;
import top.mrjello.algorithm.d4_Graph.pojo.UnionFindSet;

import java.util.Collection;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 20:01
 */
public class UnionFind {
    /**
     * 查找某一个节点所在的集合
     * @param node 节点
     *             1. 从fatherMap中获取node的父节点
     *             2. 如果父节点不是node本身，那么递归调用findFather()方法，直到找到父节点是node本身的节点
     *             3. 递归调用findFather()方法的目的是为了将node的父节点设置为node本身
     *             4. 将node的父节点设置为node本身
     *             5. 返回node的父节点
     * @return node的父节点
     */
    public Node findFather(Node node) {
        Node father = UnionFindSet.fatherMap.get(node);
        if (father != node) {
            father = findFather(father);
        }
        UnionFindSet.fatherMap.put(node, father);
        return father;
    }

    /**
     * 初始化sets
     * @param nodes 节点集合
     */
    public void makeSets(Collection<Node> nodes) {
        //清空fatherMap和rankMap
        UnionFindSet.fatherMap.clear();
        UnionFindSet.rankMap.clear();
        //遍历nodes，将每个节点放入fatherMap和rankMap中
        for (Node node : nodes) {
            //fatherMap放入节点信息
            UnionFindSet.fatherMap.put(node, node);
            //rankMap放入value为1的节点信息
            UnionFindSet.rankMap.put(node, 1);
        }
    }

    /**
     * 判断Node a和Node b是否存在同一个集合中
     * @param a 节点a
     * @param b 节点b
     * @return true: 存在同一个集合中
     */
    public boolean isSameSet(Node a, Node b) {
        //调用findFather()方法，判断a和b的父节点是否相同
        return findFather(a) == findFather(b);
    }

    /**
     * 将a节点和b节点放到同一个集合中
     * @param a 节点a
     * @param b 节点b
     */
    public void union(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        //调用findFather()方法，获取a和b的父节点
        Node aFather = findFather(a);
        Node bFather = findFather(b);
        //如果a和b的父节点不相同
        if (aFather != bFather) {
            //获取a和b的父节点的节点数
            int aFrank = UnionFindSet.rankMap.get(aFather);
            int bFrank = UnionFindSet.rankMap.get(bFather);
            //如果a的父节点的节点数小于等于b的父节点的节点数
            if (aFrank <= bFrank) {
                //将a的父节点设置为b的父节点
                UnionFindSet.fatherMap.put(aFather, bFather);
                //将b的父节点的节点数设置为a的父节点的节点数加上b的父节点的节点数
                UnionFindSet.rankMap.put(bFather, aFrank + bFrank);
            } else {
                //将b的父节点设置为a的父节点
                UnionFindSet.fatherMap.put(bFather, aFather);
                //将a的父节点的节点数设置为a的父节点的节点数加上b的父节点的节点数
                UnionFindSet.rankMap.put(aFather, aFrank + bFrank);
            }
        }
    }
}
