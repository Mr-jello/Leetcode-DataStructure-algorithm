package top.mrjello.algorithm.d2_LinkedList;

import org.junit.Test;
import top.mrjello.utils.GenAndCopyRandomArray;

/**
 * @author jason@mrjello.top
 * @date 2023/7/16 19:02
 */
public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }


    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            //next节点置为head节点的next节点
            next = head.next;
            //head节点的next节点置为pre(null)
            head.next = pre;
            //将pre节点设置为head节点
            pre = head;
            //将head节点设置为next节点
            head = next;
        }
        return pre;
    }

    public static Node reverseListWithRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //反转双链表
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    @Test
    public void testReverseList() {
        int[] arr = GenAndCopyRandomArray.generateRandomArray(5, 10);
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        Node node = reverseListWithRecursion(head);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
