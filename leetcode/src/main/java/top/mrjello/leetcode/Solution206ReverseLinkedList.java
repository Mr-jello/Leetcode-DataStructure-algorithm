package top.mrjello.leetcode;

import org.junit.Test;

/**
Given the head of a singly linked list, reverse the list, and return the
reversed list.


 Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]


 Example 2:


Input: head = [1,2]
Output: [2,1]


 Example 3:


Input: head = []
Output: []



 Constraints:


 The number of nodes in the list is the range [0, 5000].
 -5000 <= Node.val <= 5000



 Follow up: A linked list can be reversed either iteratively or recursively.
Could you implement both?

 Related Topics Linked List Recursion 👍 18614 👎 343
 * @author Jason

 */

//leetcode submit region begin(Prohibit modification and deletion)

 // Definition for singly-linked list.
 public class Solution206ReverseLinkedList {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
