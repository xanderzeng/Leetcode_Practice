/**
 *
 *
 * 707. Design Linked List
 * 
 */


class MyLinkedList {
    private class Node{
        int val;
        Node next;
        Node(int x){val = x;}
    }
    public Node head;
    public Node tail;
    private int length;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length || index < 0) return -1;
        int n = 0;
        Node ptr = head;
        while(n != index){
            ptr = ptr.next;
            n++;
        }
        return ptr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        if(tail == null) tail = n;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        if(tail == null){
            head = tail = n;
        }
        else{
            tail.next = n;
            tail = n;
        }
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length) return;
        else if(index == length) addAtTail(val);
        else if(index <= 0) addAtHead(val);
        else{
            int n = 0;
            Node ptr = head;
            while(n != index-1){
                ptr = ptr.next;
                n++;
            }
            Node node = new Node(val);
            node.next = ptr.next;
            ptr.next = node;
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
            length--;
        }
        else if(index < length && index >=0){
            Node ptr = head;
            int n =0;
            while(n != index-1){
                ptr = ptr.next;
                n++;
            }
            if(index == length - 1){
                ptr.next = null;
                tail = ptr;
            }
            else ptr.next = ptr.next.next;
            length--;
        }
        if(length == 0) tail = head = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */