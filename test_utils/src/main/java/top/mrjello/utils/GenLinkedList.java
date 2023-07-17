package top.mrjello.utils;

/**
 * @author jason@mrjello.top
 * @date 2023/7/16 19:27
 */
public class GenLinkedList {

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }


    public static ListNode genLinkedList(int maxSize, int maxValue) {
        int[] arr = GenAndCopyRandomArray.generateRandomArray(maxSize, maxValue);

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
}
