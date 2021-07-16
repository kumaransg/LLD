package LinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class removeDupUnsortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]){
        ListNode ls2 = new ListNode(3);
        ListNode ls3 = new ListNode(4);
        ls2.next =ls3;
        ListNode ls4 = new ListNode(3);
        ls3.next=ls4;
        ListNode ls5 = new ListNode(4);
        ls4.next=ls5;
        ListNode ls6 = new ListNode(3);
        ls5.next=ls6;
        ListNode ls7 = new ListNode(4);
        ls6.next=ls7;
        ls7.next=null;

        ls2 = removeDuplicates(ls2);
        while(ls2!=null){
            System.out.println(ls2.val);
            ls2=ls2.next;
        }
    }

    public static ListNode removeDuplicates(ListNode ls2){
        HashSet<Integer> hs = new HashSet<>();
        ListNode ls = new ListNode(0);
        ls.next=ls2;
        hs.add(ls2.val);
        while(ls2.next!=null){
            if(hs.contains(ls2.next.val))
            {
                ls2.next=ls2.next.next;
            }
            else
            {
                hs.add(ls2.next.val);
                ls2=ls2.next;
            }
            HashSet<Integer> h = new HashSet<>();
        }
        return ls.next;
    }
}
