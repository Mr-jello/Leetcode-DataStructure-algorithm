package top.mrjello.algorithm.d2_LinkedList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/19 19:17
 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 查询相交链表的第一个节点
     * 1. 两个链表同时无环（走noLoop），判断二者是否相交，若相交一定成Y型，或者是I型（即二者是包含关系），但二者的共同点是终点相同
     * 2. 两个链表只有一个有环，一定不可能相交
     * 3. 两个链表都有环，判断二者是否相交，有三种情况：
     *      I：二者不相交，各自成环。
     *      II：二者在环外相交，成Y型。
     *      III：二者在环内相交，类似耳朵型。
     * @param head1 链表1
     * @param head2 链表2
     * @return 相交链表的第一个节点
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        //先判断自身链表是否有环
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        //如果head1和head2所在的链表各自都没有环，则判断二者是否相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        //如果head1和head2所在的链表存在环，则判断二者是否相交，loop为自身存在环时自身的交点
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    /**
     * 用于判断自身链表是否有环: 流程快慢指针，但是快指针每次走两步，慢指针每次走一步
     *      1. 如果快指针走到null，则无环
     *      2. 如果有环则快慢指针一定会在环上相遇，且快指针不会超过慢指针两圈
     *      3. 快慢指针相遇后，快指针回到头节点，快慢指针同时走，再次相遇的位置即为环的入口节点
     * @param head 链表头节点
     * @return 环的入口节点
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slowCur = head.next;
        Node fastCur = head.next.next;
        while (slowCur != fastCur) {
            if (fastCur.next == null || fastCur.next.next == null) {
                return null;
            }
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }
        fastCur = head;
        while (slowCur != fastCur) {
            slowCur = slowCur.next;
            fastCur = fastCur.next;
        }
        return slowCur;
    }

    /**
     * 二者相交且没有环，则只能是Y型，或者是I型（即二者是包含关系），但二者的共同点是终点相同
     * 1. 若两者不相交：则两者的终点（内存地址）不同
     * 2. 若两者相交为Y型：
     *              I: 两者的终点（内存地址）相同
     *              II: 记录两者的长度，长的先走两者长度差的步数，然后两者同时走，再次相遇的位置即为相交的第一个节点
     * @param head1 链表1
     * @param head2 链表2
     * @return 相交链表的第一个节点
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;

        //记录两者的长度差值
        int length = 0;
        while (cur1.next != null) {
            length++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            length--;
            cur2 = cur2.next;
        }

        //若两者不相交：则两者的终点（内存地址）不同
        if (cur1 != cur2) {
            return null;
        }

        //若两者相交为Y型：
        // length > 0 说明链表1比链表2长
        //  cur1指向长的链表，cur2指向短的链表
        cur1 = length > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        //长链表先走差值步（length）
        length = Math.abs(length);
        while (length != 0) {
            length--;
            cur1 = cur1.next;
        }

        //此时两者同时走，再次相遇的位置即为相交的第一个节点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;

        //如果两者的环入口节点相同，则为Y型，入环节点可看成两者的终点,同上述noLoop
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;

            //记录两者的长度差值
            int length = 0;
            while (cur1.next != null) {
                length++;
                cur1 = cur1.next;
            }
            while (cur2.next != null) {
                length--;
                cur2 = cur2.next;
            }

            //若两者相交为Y型：
            // length > 0 说明链表1比链表2长
            //  cur1指向长的链表，cur2指向短的链表
            cur1 = length > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            //长链表先走差值步（length）
            length = Math.abs(length);
            while (length != 0) {
                length--;
                cur1 = cur1.next;
            }
            //此时两者同时走，再次相遇的位置即为相交的第一个节点
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        //如果两者的环入口节点不同，则为耳朵型
        }else {
            //从loop1开始走，如果能走回loop2，则为耳朵型
            cur1 = loop1.next;
            //遍历两者相同地环，如果走一圈后，遇得到loop2，则为耳朵型，返回两者的环入口节点
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            //如果走一圈后，没有遇到loop2，则两者不相交，各自成环
            return null;
        }
    }
}
