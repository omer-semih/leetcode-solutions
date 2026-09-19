// LeetCode 19: Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // If there is only one node, removing it leaves an empty list
        if(head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = slow;

        // Move the fast pointer n steps ahead to create a gap
        for(int i=0;i<n;i++) {
            fast = fast.next;
        }

        // If fast reaches the end, we need to remove the first node
        if(fast == null) return head.next;

        // Move both pointers until fast reaches the last node
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return head;

    }
}