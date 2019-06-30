/**
 *
 *
 * 23. Merge k Sorted Lists
 * 
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        int step = 2;
        while(step < n<<1){
            for(int i = 0; i < n; i += step){
                int p = step >> 1;
                if((i+p) >= n) continue;
                ListNode f = lists[i];
                ListNode s = lists[i+p];
                lists[i] = sort(f,s);
            }
            step <<= 1;
        }
        return lists[0];
    }
    
    public ListNode sort(ListNode f, ListNode s){
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while(f != null && s != null){
            if(f.val < s.val){
                pre.next = f;
                f = f.next;
            }
            else{
                pre.next = s;
                s = s.next;
            }
            pre = pre.next;
        }
        if(f != null) pre.next = f;
        if(s != null) pre.next = s;
        return head.next;
    }
    

}