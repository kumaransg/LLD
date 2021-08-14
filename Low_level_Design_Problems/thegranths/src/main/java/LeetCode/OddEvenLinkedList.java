package LeetCode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHeadPointer = even;


        while(even!=null && even.next !=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next = evenHeadPointer;

        return head;
    }
}
