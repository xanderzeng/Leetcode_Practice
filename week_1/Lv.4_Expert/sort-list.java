/**
 *
 * 148. Sort List
 *
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode l = head;
        ListNode r = findMiddle(head);
        l = mergeSort(l);
        r = mergeSort(r);
        if(l.val < r.val){
            head = l;
            l = l.next;
            head.next = null;
        }
        else{
            head = r;
            r = r.next;
            head.next = null;
        }
        ListNode ptr = head;
        while(l != null && r != null){
            if(l.val < r.val){
                ptr.next = l;
                l = l.next;
                ptr = ptr.next;
                ptr.next = null;
            }
            else{
                ptr.next = r;
                r = r.next;
                ptr = ptr.next;
                ptr.next = null;
            }
        }
        if(l!=null) ptr.next = l;
        if(r!=null) ptr.next = r;
        return head;
    }
    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
}