/**
 *
 *
 * 61. Rotate List
 * 
 */


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode ptr = head;
        int n = 1;
        while(ptr.next != null){
            ptr = ptr.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;
        ptr = head;
        int i = 1;
        while(i != n - k ){
            ptr = ptr.next;
            i++;
        }
        ListNode next = ptr.next;
        ptr.next = null;
        ptr = next;
        while(ptr.next != null) ptr = ptr.next;
        ptr.next = head;
        head = next;
        return head;
    }
}