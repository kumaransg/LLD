package LeetCode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next =null;

        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */