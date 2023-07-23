package top.mrjello.algorithm.d3_BinaryTree;



import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jason@mrjello.top
 * @date 2023/7/19 20:22
 */
public class PreInPosTraversal {

        public static class Node {
            public int value;
            public Node left;
            public Node right;

            public Node(int value) {
                this.value = value;
            }
        }

        //递归序列化
        public static void recurSerialize(Node head) {
            if (head == null) {
                return;
            }

            System.out.print(head.value + ",");
            recurSerialize(head.left);
            System.out.print(head.value + ",");
            recurSerialize(head.right);
            System.out.print(head.value + ",");
        }

        //先序遍历就是二叉树的深度优先遍历
        public static void depthFirstSearch(Node head) {
            if (head == null) {
                return;
            }
            System.out.print(head.value + " ");
            depthFirstSearch(head.left);
            depthFirstSearch(head.right);
        }

        //宽度优先遍历的非递归实现
        public static void widthFirstSearch(Node head) {
            if (head == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                System.out.print(head.value + " ");
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
        }

        //先序遍历: 头左右
        public static void preOrderRecur(Node head) {
            if (head == null) {
                return;
            }
            System.out.print(head.value + " ");
            preOrderRecur(head.left);
            preOrderRecur(head.right);
        }

        //中序遍历： 左头右
        public static void inOrderRecur(Node head) {
            if (head == null) {
                return;
            }
            inOrderRecur(head.left);
            System.out.print(head.value + " ");
            inOrderRecur(head.right);
        }

        //后序遍历： 左右头
        public static void posOrderRecur(Node head) {
            if (head == null) {
                return;
            }
            posOrderRecur(head.left);
            posOrderRecur(head.right);
            System.out.print(head.value + " ");
        }


    /**
     * 利用堆实现先序遍历
     * 1. 如果head节点不为null，则加入堆中后利用变量head指向堆中弹出的数后打印
     * 2. 当弹出的数的右节点不为null，先压又后压左
     * 3. 循环过程中，head指向堆中弹出的数
     * @param head 头节点
     */
        public static void preOrderUnRecur(Node head) {
            System.out.println("pre-order-UnRecur:========================== ");
            if (head != null) {
                Stack<Node> stack = new Stack<Node>();
                stack.add(head);
                while (!stack.isEmpty()) {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    if (head.right != null) {
                        stack.add(head.right);
                    }
                    if (head.left != null) {
                        stack.add(head.left);
                    }
                }
            }
        }

        /**
         * 利用堆实现中序遍历
         * 1. 如果head节点不为null，则加入堆中后利用变量head指向堆中弹出的数后打印
         * 2. 当弹出的数的右节点不为null，先压又后压左
         * 3. 循环过程中，head指向堆中弹出的数
         * @param head 头节点
         */
        public static void inOrderUnRecur(Node head) {
            System.out.println("in-order-UnRecur:========================== ");
            if (head != null) {
                Stack<Node> stack = new Stack<Node>();
                while (!stack.isEmpty() || head != null) {
                    if (head != null) {
                        stack.add(head);
                        head = head.left;
                    }else {
                        head = stack.pop();
                        System.out.print(head.value + " ");
                        head = head.right;
                    }
                }
            }
            System.out.println();
        }



        /**
         * 利用堆实现后序遍历
         * 1. 如果head节点不为null，则加入堆中后利用变量head指向堆中弹出的数
         * 2. 当弹出的数的左节点不为null，先压左后压右： 先出右后出左
         * 3. 将弹出的数压入另一个堆中 ： 压入顺序为：头右左 ；  弹出顺序为：左右头
         * 4. 循环过程中
         * @param head 头节点
         */
        public static void posOrderUnRecur(Node head) {
            System.out.println("pos-order-UnRecur:========================== ");
            if (head != null) {
                Stack<Node> stack = new Stack<Node>();
                Stack<Node> stack2 = new Stack<Node>();
                stack.add(head);
                while (!stack.isEmpty()) {
                    head = stack.pop();
                    stack2.add(head);
                    if (head.left != null) {
                        stack.add(head.left);
                    }
                    if (head.right != null) {
                        stack.add(head.right);
                    }
                }
                while (!stack2.isEmpty()) {
                    System.out.print(stack2.pop().value + " ");
                }
            }
            System.out.println();
        }
















    @Test
        public void testRecursive() {
            Node head = new Node(1);
            head.left = new Node(2);
            head.right = new Node(3);
            head.left.left = new Node(4);
            head.left.right = new Node(5);
            head.right.left = new Node(6);
            head.right.right = new Node(7);

            System.out.println("==============recursive==============");
            posOrderUnRecur(head);
        }

}
