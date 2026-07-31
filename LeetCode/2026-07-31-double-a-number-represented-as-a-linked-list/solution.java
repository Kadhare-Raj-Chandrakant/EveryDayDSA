// Time complexity: O(n), where n is the number of nodes in the linked list
// Space complexity: O(n), in the worst case when the input is a list of 9's
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode temp = head;
        int carry = 0;
        
        while (temp != null) {
            int val = temp.val * 2 + carry;
            carry = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            temp = temp.next;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}