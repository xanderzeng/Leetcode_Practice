/**
 *
 * 160. Intersection of Two Linked Lists
 *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        while(ptr1 != null && ptr2 != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr2 != null){
            ptr2 = ptr2.next;
            headB = headB.next;
        }
        while(ptr1 != null){
            ptr1 = ptr1.next;
            headA = headA.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}