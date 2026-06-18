// LeetCode 2: Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *result = new ListNode();
        ListNode *head = result; // Keep a pointer to the head to return later
        int carry=0;

        // Continue until both lists are exhausted and no carry remains
        while(l1 != nullptr || l2 != nullptr || carry>0) {
            // Treat missing nodes as 0
            int val1 = (l1 == nullptr) ? 0 : l1->val;
            int val2 = (l2 == nullptr) ? 0 : l2->val;

            int digit = val1 + val2 + carry;
            carry = digit/10; // Pass the tens digit to the next iteration

            result->next = new ListNode(digit%10); // Store only the ones digit
            result = result->next;

            if(l1 != nullptr) l1 = l1->next;
            if(l2 != nullptr) l2 = l2->next;
        }
        return head->next;
    }

};