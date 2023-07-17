package top.mrjello.algorithm.d2_LinkedList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/16 20:11
 */
public class CommonPartOfTwoLinkedList {

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 一个指针指向第一个链表头，另外一个指向第二个链表头
     * 比大小，谁更小谁移动到下一个
     * 如果遇到一样的，记录那个一样的，然后共同移动 (两个都往下一个移，说不定还有一样的)
     * 任何一个链表到头了，结束
     * @param head1 链表1
     * @param head2 链表2
     */
    public static void printCommonPart(Node head1, Node head2){
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            }else if (head1.value > head2.value) {
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
