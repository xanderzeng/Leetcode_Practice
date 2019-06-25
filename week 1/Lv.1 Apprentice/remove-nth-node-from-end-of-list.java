/**
19. Remove Nth Node From End of List
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        if(n > 1){
            for(int i = 0;i<n-1;i++){
                if(fast.next == null) return null;
                fast = fast.next;
            }
            ListNode slow = head;
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.val = slow.next.val;
            slow.next = slow.next.next;
            return head;
        }
        else{
            if(fast.next == null) return null;
            fast = fast.next;
            ListNode slow = head;
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}