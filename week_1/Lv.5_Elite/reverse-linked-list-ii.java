/**
 *
 *
 * 25. Reverse Nodes in k-Group
 * 
 */


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode blank = new ListNode(0);
        blank.next = head;
        ListNode prev = blank;
        
        while(prev.next != null){
            ListNode ptr = prev.next;
            boolean canReverse = true;
            for(int i = 1;i<k;i++){
                if(ptr.next == null){
                    canReverse = false;
                    break;
                }
                ptr = ptr.next;
            }
            if(!canReverse) break;
            ptr = prev.next;
            for(int i = 1;i<k;i++){
                ListNode next = ptr.next;
                ptr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = ptr;
        }
        return blank.next;
    }
}
