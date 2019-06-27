/**
 *
 * 21. Merge Two Sorted Lists
 *
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode result_ptr = result;
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        
        boolean isEnd = false;
        while(!isEnd){
            if(l1_ptr == null && l2_ptr == null) break;
            else if(l1_ptr == null){
                result_ptr.next = l2_ptr;
                break;
            }
            else if(l2_ptr == null){
                result_ptr.next = l1_ptr;
                break;
            }
            else{
                int l1_val = l1_ptr.val;
                int l2_val = l2_ptr.val;
                if(l1_val < l2_val){
                    result_ptr.next = new ListNode(l1_val);
                    l1_ptr = l1_ptr.next;
                }
                else{
                    result_ptr.next = new ListNode(l2_val);
                    l2_ptr = l2_ptr.next;
                }
                result_ptr = result_ptr.next;
            }
        }
        
        return result.next;
    }
}