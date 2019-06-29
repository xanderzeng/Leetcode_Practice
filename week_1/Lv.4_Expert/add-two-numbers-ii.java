/**
 *
 * 445. Add Two Numbers II
 *
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //let l1 point to the longer one
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while(ptr1 != null && ptr2 != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr2 != null){
            ListNode n = new ListNode(0);
            n.next = l1;
            l1 = n;
            ptr2 = ptr2.next;
        }
        while(ptr1 != null){
            ListNode n = new ListNode(0);
            n.next = l2;
            l2 = n;
            ptr1 = ptr1.next;
        }
        int rest = recursive(l1,l2);
        if(rest != 0){
            ListNode n = new ListNode(rest);
            n.next = l1;
            l1 = n;
        }
        while(l1.val == 0){
            if(l1.next == null)break;
            ptr1 = l1.next;
            l1.next = null;
            l1 = ptr1;
        }
        return l1;
    }
    
    public int recursive(ListNode l1, ListNode l2){
        if(l1.next == null && l2.next == null){
            l1.val = l1.val+l2.val;
            int rest = l1.val / 10;
            l1.val = l1.val % 10;
            return rest;
        }
        int rest = recursive(l1.next,l2.next);
        if(rest != 0) l1.val += rest;
        l1.val = l1.val+l2.val;
        rest = l1.val / 10;
        l1.val = l1.val % 10;
        return rest;
    }
}