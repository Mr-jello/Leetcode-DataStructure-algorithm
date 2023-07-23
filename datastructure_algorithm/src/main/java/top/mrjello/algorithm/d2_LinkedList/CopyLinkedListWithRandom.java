package top.mrjello.algorithm.d2_LinkedList;

import java.util.HashMap;

/**
 * @author jason@mrjello.top
 * @date 2023/7/18 0:52
 */
public class CopyLinkedListWithRandom {

    /**
     * 复制含有随机指针节点的链表
     * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。给定一个由Node节点类型组成的无环单链表的头节点
     * 【要求】时间复杂度O(N)，额外空间复杂度O(1)
     */
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用map: key：Node原始类型的节点，value：Node新创建类型的节点
     * 1. 遍历原始链表，将原始链表的节点信息写入map
     * 2. 回到原始链表的头节点，遍历原始链表，获取原始链表的节点的next和rand，然后将新创建的节点的next和rand指向map中的新创建的节点
     * 3. 返回map中的新创建的头节点
     * Key和Value都是Node类型，存放的都为Node类型的内存地址
     * 空间复杂度O(N)，时间复杂度O(N)
     * @param head 原始链表的头节点
     * @return 新创建链表的头节点
     */
    public static Node copyLinkedListWithRandomUseMap(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        //遍历原始链表，将原始链表的节点信息写入map
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        //回到原始链表的头节点，遍历原始链表，获取原始链表的节点的next和rand，然后将新创建的节点的next和rand指向map中的新创建的节点
        cur = head;
        while (cur != null) {
            //map.get(cur)：获取map中key为cur的value，即新创建的节点
            //map.get(cur).next: 获取map中key为cur的value的next，即新创建的节点的next
            //map.get(cur.next): 获取map中key为cur.next的value，即新创建的节点
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 不使用map，使每个原节点的next为新创建的节点
     * 空间复杂度O(1)
     * @param head 原始链表的头节点
     * @return 新创建链表的头节点
     */
    public static Node optimizeCopyLinkedListWithRandom(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        //next为原节点的next
        Node next = null;
        //1. 复制原始链表的每个节点，将新创建的节点放在原节点的后面
        while (cur != null) {
            //next为原节点的next
            next = cur.next;
            //cur.next为新创建的节点
            cur.next = new Node(cur.value);
            //新创建的节点的next为原节点的next
            cur.next.next = next;
            //cur指向原节点的next
            cur = next;
        }
        //2. 设置新创建的节点的rand
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            //next为原节点的next
            next = cur.next.next;
            //curCopy为新创建的节点
            curCopy = cur.next;
            //curCopy的rand为原节点的rand的next
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            //cur指向原节点的next
            cur = next;
        }
        //3. 拆分链表
        Node res = head.next;
        cur = head;
        while (cur != null) {
            //next为原节点的next
            next = cur.next.next;
            //curCopy为新创建的节点
            curCopy = cur.next;
            //cur指向原节点的next
            cur.next = next;
            //curCopy的next为原节点的next的next
            curCopy.next = next != null ? next.next : null;
            //cur指向原节点的next
            cur = next;
        }
        return res;
    }
}
