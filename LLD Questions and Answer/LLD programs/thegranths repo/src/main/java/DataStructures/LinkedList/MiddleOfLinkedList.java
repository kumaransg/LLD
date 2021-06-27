package DataStructures.LinkedList;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast.next!=null) slow=slow.next;

        return slow;
    }
}
