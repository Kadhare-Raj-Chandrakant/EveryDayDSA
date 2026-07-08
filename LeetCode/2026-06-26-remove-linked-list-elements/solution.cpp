// Time complexity: O(n), where n is the number of nodes in the linked list.
// Space complexity: O(1), as we only use a constant amount of space.

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        // Create a dummy node to simplify the edge case where the head node needs to be removed
        ListNode dummy(0);
        dummy.next = head;
        
        ListNode* prev = &dummy;
        
        // Traverse the linked list
        while (prev->next) {
            // If the current node's value matches the target value, remove it
            if (prev->next->val == val) {
                prev->next = prev->next->next;
            } else {
                // Otherwise, move to the next node
                prev = prev->next;
            }
        }
        
        // Return the new head of the modified linked list
        return dummy.next;
    }
};