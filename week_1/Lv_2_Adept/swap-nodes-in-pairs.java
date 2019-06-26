/**
 * 
 * 24. Swap Nodes in Pairs
 * 
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //return recursive(head);
        return iterative(head);
    }
    
    public ListNode recursive(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = recursive(head.next);
        return next;
    }
    
    public ListNode iterative(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode next = cur.next;
        head = next;
        while(next != null){
            cur.next = next.next;
            next.next = cur;
            if(cur.next == null || cur.next.next == null) break;
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
            next = cur.next;
        }
        return head;
    }
}