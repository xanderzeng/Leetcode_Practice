/**
 *
 *
 * 61. Rotate List
 * 
 */


class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;
    ListNode(int x,int y){key = x; val = y;}
}



class LRUCache {
    ListNode head;
    ListNode tail;
    int count;
    int capacity;
    HashMap<Integer, ListNode> map;
    
    private void pushToHead(ListNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void popFromTail(){
        ListNode prev = tail.prev;
        tail.prev = prev.prev;
        prev.prev.next = tail;
        prev.prev = null;
        prev.next = null;
        map.remove(prev.key);
    }
    
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        map = new HashMap<Integer, ListNode>();
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if(node == null) return -1;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        pushToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if(node != null){
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            pushToHead(node);
        }
        else{
            node = new ListNode(key,value);
            map.put(key,node);
            pushToHead(node);
            count++;
            if(count > capacity){
                popFromTail();
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */