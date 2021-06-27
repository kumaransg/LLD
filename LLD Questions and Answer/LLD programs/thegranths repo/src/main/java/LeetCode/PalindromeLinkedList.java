package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null) slow=slow.next;
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null,next=null,curr=head;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
