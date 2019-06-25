/**
206. Reverse Linked List
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	//return recursive(head);
        return iterative(head);
        
    }
    
    public ListNode recursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = recursive(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    
    public ListNode iterative(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur = prev.next;
        }
        return head;
        
    }
}