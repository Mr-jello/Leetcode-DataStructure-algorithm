package top.mrjello.algorithm.d2_LinkedList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/17 22:47
 * 三部分链表: 将链表划分为三部分，小于某个值，等于某个值，大于某个值
 */
public class ThreePartOfLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一：将链表放入数组中，然后对数组进行partition，最后将数组中的节点串起来
     * 1. 将链表中的值放入数组中
     * 2. 对数组进行partition
     * 3. 将数组中的值放回链表中
     * @param head 链表头节点
     * @param pivot 分割值
     * @return 分割后的链表头节点
     */
    public static Node partitionLinkedList(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        // 计算链表长度
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        // 将链表中的值放入数组中
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 对数组进行partition
        arrPartition(nodeArr, pivot);
        // 将数组中的值放回链表中
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        // 最后一个节点的next指针指向null
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        // 小于pivot的最后一个节点的下标
        int small = -1;
        // 大于pivot的第一个节点的下标
        int big = nodeArr.length;
        // 当前节点的下标
        int index = 0;
        // 当前节点的下标小于大于pivot的第一个节点的下标时，循环
        while (index != nodeArr.length) {
            // 当前节点的值小于pivot时，将当前节点与小于pivot的最后一个节点的下一个节点交换，然后将小于pivot的最后一个节点的下标+1，当前节点的下标+1
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            }else if(nodeArr[index].value == pivot){
                // 当前节点的值等于pivot时，当前节点的下标+1
                index++;
            }else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int i, int j) {
        Node tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }

    /**
     * 方法二：将链表划分为三部分，小于pivot的部分，等于pivot的部分，大于pivot的部分
     * 1. 仅使用有限个变量，将链表划分为三部分，最后串联起来
     * @param head 链表头节点
     * @param pivot 分割值
     * @return 分割后的链表头节点
     */
    public static Node optimizeThreePartOfLinkedList(Node head, int pivot){
        Node sH = null; // 小于pivot的头节点
        Node sT = null; // 小于pivot的尾节点
        Node eH = null; // 等于pivot的头节点
        Node eT = null; // 等于pivot的尾节点
        Node bH = null; // 大于pivot的头节点
        Node bT = null; // 大于pivot的尾节点
        Node next = null; // 下一个节点
        // 将链表划分为三部分
        while (head != null) {
            // 将head.next赋值给next，防止head.next指向的节点丢失
            next = head.next;
            // 将head.next指向null，防止head.next指向的节点丢失
            head.next = null;
            // 将head节点放入对应的链表中
            if (head.value < pivot) {
                //如果某个值<分割值，且<分割值的链表为空，则将该值赋值给小于分割值的链表的头节点和尾节点
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    //如果某个值<分割值，且<分割值的链表不为空，则将该值赋值给小于分割值的链表的尾节点的next指针，然后将该值赋值给小于分割值的链表的尾节点
                    sT.next = head;
                    sT = head;
                }
                //如果某个值=分割值，且=分割值的链表为空，则将该值赋值给等于分割值的链表的头节点和尾节点
            }else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                }else {
                    //如果某个值=分割值，且=分割值的链表不为空，则将该值赋值给等于分割值的链表的尾节点的next指针，然后将该值赋值给等于分割值的链表的尾节点
                    eT.next = head;
                    eT = head;
                }
                //如果某个值>分割值，且>分割值的链表为空，则将该值赋值给大于分割值的链表的头节点和尾节点
            }else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                }else {
                    //如果某个值>分割值，且>分割值的链表不为空，则将该值赋值给大于分割值的链表的尾节点的next指针，然后将该值赋值给大于分割值的链表的尾节点
                    bT.next = head;
                    bT = head;
                }
            }
            // 将head指向next，继续循环
            head = next;
        }
        // 将小于pivot的链表和等于pivot的链表连接起来
        if (sT != null) {
            sT.next = eH;
            // 如果等于pivot的链表不为空，且大于pivot的链表为空，则将等于pivot的链表和大于pivot的链表连接起来
            eT = eT == null ? sT : eT;
        }
        // 将等于pivot的链表和大于pivot的链表连接起来
        if (eT != null) {
            eT.next = bH;
        }
        // 返回小于pivot的链表的头节点
        return sH != null ? sH : eH != null ? eH : bH;
    }

}
