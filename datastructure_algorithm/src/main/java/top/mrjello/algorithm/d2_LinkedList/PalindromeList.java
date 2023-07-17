package top.mrjello.algorithm.d2_LinkedList;

import java.util.Stack;

/**
 * @author jason@mrjello.top
 * @date 2023/7/16 20:56
 */
public class PalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindromeListUseStack(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeListUseHalfStack(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slowCur = head.next;
        Node fastCur = head;
        //慢指针找到中点,快指针找到尾节点
        while (fastCur.next != null && fastCur.next.next != null) {
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        //将慢指针至最后的节点都推入堆中
        while (slowCur != null) {
            stack.push(slowCur);
            slowCur = slowCur.next;
        }
        //比较
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeListOptimized(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slowCur = head;
        Node fastCur = head;
        //慢指针找到中点,快指针找到尾节点
        while (fastCur.next != null && fastCur.next.next != null) {
            slowCur = slowCur.next; // slow -> mid
            fastCur = fastCur.next.next; // fast -> end
        }
        //修改中间右边的节点指向，形成逆序对
        fastCur = slowCur.next; // fast -> right part first node
        slowCur.next = null; // mid.next -> null
        Node temp = null;
        //将中间右边的节点逆序
        while (fastCur != null) {
            temp = fastCur.next; // temp -> save next node temp指定为fastCur下一位
            fastCur.next = slowCur; // next of right node convert 将fastCur的下一位指向slowCur
            slowCur = fastCur; // slow move, slow -> fastCur slowCur指定为fastCur.向后移动
            fastCur = temp; // fast move, fastCur -> temp fastCur指定为temp.向后移动
        }
        //比较
        temp = slowCur; // temp -> save last node temp修改为slowCur保存最后一个节点
        fastCur = head; // fast -> left first node fastCur指定为head
        boolean res = true;
        while (slowCur != null && fastCur != null) {
            if (slowCur.value != fastCur.value) {
                res = false;
                break;
            }
            slowCur = slowCur.next; // left to mid
            fastCur = fastCur.next; // right to mid
        }
        //恢复链表
        slowCur = temp.next; // slow -> right first node
        temp.next = null; // mid.next -> null
        while (slowCur != null) {
            fastCur = slowCur.next; // fast -> save next node
            slowCur.next = temp; // next of right node convert
            temp = slowCur; // temp move
            slowCur = fastCur; // slow move
        }
        return res;
    }
}
