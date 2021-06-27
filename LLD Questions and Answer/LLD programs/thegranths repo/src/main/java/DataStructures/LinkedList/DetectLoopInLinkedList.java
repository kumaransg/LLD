package DataStructures.LinkedList;

public class DetectLoopInLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }

        return false;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }