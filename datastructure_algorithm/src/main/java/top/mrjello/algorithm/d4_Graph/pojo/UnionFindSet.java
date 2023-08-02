package top.mrjello.algorithm.d4_Graph.pojo;

import java.util.HashMap;

/**
 * @author jason@mrjello.top
 * @date 2023/7/23 19:56
 */
public class UnionFindSet {
    //fatherMap: key为节点，value为节点的父节点
    public static HashMap<Node, Node> fatherMap;
    //rankMap: key为节点，value为节点所在集合的节点数
    public static HashMap<Node, Integer> rankMap;

    public UnionFindSet() {
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

}
