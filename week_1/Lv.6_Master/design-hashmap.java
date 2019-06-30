/**
 *
 *
 * 706. Design HashMap
 * 
 */


class MyHashMap {
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode prev;
        ListNode(int x,int y){key = x; value = y; prev = null; next = null;}
    }
    ListNode[] table;
    int hash = 10000;
    

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new ListNode[hash];
        for(int i =0;i<hash;i++) table[i] = new ListNode(0,0);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % hash;
        ListNode ls = table[index];
        while(ls.next != null){
            ls = ls.next;
            if(ls.key == key){
                ls.value = value;
                return;
            }
        }
        ListNode n = new ListNode(key,value);
        n.next = table[index].next;
        n.prev = table[index];
        if(table[index].next != null) table[index].next.prev = n;
        table[index].next = n;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % hash;
        ListNode ls = table[index];
        while(ls.next != null){
            ls = ls.next;
            if(ls.key == key) return ls.value;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % hash;
        ListNode ls = table[index];
        while(ls.next != null){
            ls = ls.next;
            if(ls.key == key){
                ls.prev.next = ls.next;
                if(ls.next != null) ls.next.prev = ls.prev;
                return;
            }
            
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */