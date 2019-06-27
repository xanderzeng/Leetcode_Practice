/**
 *
 * 142. Linked List Cycle II
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //return mapping(head);
        return twoPointer(head);
    }
    
    public ListNode twoPointer(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    
    public ListNode mapping(ListNode head){
        //This solution is very slow
        Set<ListNode> set = new HashSet<ListNode>();
        while(!set.contains(head)){
            if(head == null) return null;
            set.add(head);
            head = head.next;
        }
        return head;
    }
}