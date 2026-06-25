class Solution {
public:
    // Time complexity: O(n), where n is the number of nodes in the list
    // Space complexity: O(1), as we only use a constant amount of space
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr != nullptr) {
            ListNode* nextTemp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
};