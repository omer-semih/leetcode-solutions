// LeetCode 141: Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/description/?envType=problem-list-v2&envId=xix1yu51

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Floyd's Tortoise and Hare algorithm
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) return false;

        ListNode slowPointer=head, fastPointer=head;

        // Speed of the slow pointer is 1 & fast pointer = 2
        // Let's say the distance between them is x. At each iteration x decreases by 1. So they eventually meet
        // Cycle detection approach
        do {
            if(fastPointer.next == null || fastPointer.next.next == null) {
                return false;
            }
            else {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        } while(slowPointer != fastPointer);

        return true;
    }
}