/**
203. Remove Linked List Elements
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)head = head.next;
        if(head == null || head.next == null) return head;
        ListNode ptr = head.next;
        ListNode pre = head;
        while(ptr != null){
            if(ptr.val == val){
                pre.next = ptr.next;
                ptr = ptr.next;
            }
            else{
                pre = ptr;
                ptr = ptr.next;
            }
        }
        return head;
    }
}