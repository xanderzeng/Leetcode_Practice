/**
 *
 * 82. Remove Duplicates from Sorted List II
 *
 */


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        int mark = head.val;
        int count = 1;
        ListNode ptr = head;
        ListNode prev = null;
        while(ptr.next != null){
            if(ptr.next.val == mark) count++;
            else{
                if(count > 1){
                    if(prev == null) head = ptr.next;
                    else prev.next = ptr.next;
                }
                else prev = ptr;
                count = 1;
                mark = ptr.next.val;
            }
            ptr = ptr.next;
            
        }
        if(count > 1){
            if(prev == null) return null;
            prev.next = null;
        }
        return head;
    }
}