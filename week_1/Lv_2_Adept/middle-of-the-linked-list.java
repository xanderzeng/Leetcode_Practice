/**
 * 
 * 876. Middle of the Linked List
 * 
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode tradition(ListNode head){
        if(head == null) return head;
        int n = 1;
        ListNode ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
            n++;
        }
        int mid = n/2+1;
        n = 1;
        ptr = head;
        while(n != mid){
            ptr = ptr.next;
            n++;
        }
        return ptr;
    }
}