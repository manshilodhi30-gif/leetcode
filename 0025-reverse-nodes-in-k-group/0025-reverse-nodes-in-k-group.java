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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }
        ListNode newHead = reverse(head, node);
        head.next = reverseKGroup(node, k);
        return newHead;
    }

    private ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = last;
        while (first != last) {
            ListNode tmp = first.next;
            first.next = prev;
            prev = first;
            first = tmp;
        }
        return prev;
    }
}