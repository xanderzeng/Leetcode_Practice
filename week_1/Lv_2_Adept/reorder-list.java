/**
 * 
 * 143. Reorder List
 * 
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = findMiddle(head);
        mid = reverse(mid);
        ListNode l = head;
        ListNode r = mid;
        while(l != null){
            ListNode next = l.next;
            l.next = r;
            l = next;
            next = r.next;
            if(l != null)r.next = l;
            r = next;
        }
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    } 
}