/**
83. Remove Duplicates from Sorted List
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while(iter != null && iter.next != null){
            if(iter.val == iter.next.val) iter.next = iter.next.next;
            else iter = iter.next;
        }
        return head;
    }
}