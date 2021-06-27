package LeetCode;

public class MergeKSortedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for(int i=0;i<lists.length;i++){
            merge(lists[i],result);
        }

        return result.next;
    }

    ListNode merge (ListNode a,ListNode b){
        if(a==null) return b;
        if(b==null) return a;

        ListNode tmp;

        if(a.val<b.val){
            tmp = a;
            tmp.next=merge(a.next,b);
        }else{
            tmp=b;
            tmp.next=merge(a,b.next);
        }
        return tmp;
    }
}
