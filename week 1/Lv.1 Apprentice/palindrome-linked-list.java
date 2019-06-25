/**
234. Palindrome Linked List
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int n = 1;
        ListNode fast = head;
        while(fast.next != null){
            fast = fast.next;
            n++;
        }
        int mid = n/2;
        n = 1;
        ListNode slow = head;
        while(n != mid){
            slow = slow.next;
            n++;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        while(head != null){
            if(fast.val != head.val) return false;
            head = head.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}