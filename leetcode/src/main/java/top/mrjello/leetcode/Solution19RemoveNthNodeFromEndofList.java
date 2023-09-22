package top.mrjello.leetcode; /**
Given the head of a linked list, remove the nᵗʰ node from the end of the list
and return its head.


 Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


 Example 2:


Input: head = [1], n = 1
Output: []


 Example 3:


Input: head = [1,2], n = 1
Output: [1]



 Constraints:


 The number of nodes in the list is sz.
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz



 Follow up: Could you do this in one pass?

 Related Topics Linked List Two Pointers 👍 17192 👎 706

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution19RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (n > 0) {
            if (cur1 == null) {
                return head;
            }
            cur1 = cur1.next;
            n--;
        }
        if (cur1 == null) {
            return head.next;
        }
        while (cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
