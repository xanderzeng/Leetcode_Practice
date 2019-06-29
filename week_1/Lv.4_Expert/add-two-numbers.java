/**
 *
 * 2. Add Two Numbers
 *
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isEnd = false;
        int rest = 0;
        ListNode result = new ListNode(0);
        ListNode result_ptr = result;
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        while(!isEnd){
            int l1_value = 0;
            int l2_value = 0;
            if(l1_ptr != null) l1_value = l1_ptr.val;
            if(l2_ptr != null) l2_value = l2_ptr.val;
            int sum = l1_value + l2_value + rest;
            rest = sum / 10; 
            result_ptr.next = new ListNode(sum % 10);
            result_ptr = result_ptr.next;
            if(l1_ptr != null) l1_ptr = l1_ptr.next;
            if(l2_ptr != null) l2_ptr = l2_ptr.next;
            if(l1_ptr == null && l2_ptr == null && rest == 0) isEnd = true;
        }
        
        return result.next;
    }
}