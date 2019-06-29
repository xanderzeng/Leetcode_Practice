/**
 *
 *
 * 430. Flatten a Multilevel Doubly Linked List
 * 
 */


class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node ptr = head;
        while(ptr != null){
            if(ptr.child != null){
                Node next = ptr.next;
                Node child = flatten(ptr.child);
                ptr.child = null;
                ptr.next = child;
                child.prev = ptr;
                if(next!= null){
                    while(child.next != null) child = child.next;
                    child.next = next;
                    next.prev = child;
                }
                ptr = next;
            }
            else ptr = ptr.next;
        }
        return head;
    }
}
