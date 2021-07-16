package LinkedList;

import java.util.Arrays;
import java.util.Collections;

public class sortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]){
        ListNode ls2 = new ListNode(4);
        ListNode ls3 = new ListNode(2);
        ls2.next =ls3;
        ListNode ls4 = new ListNode(1);
        ls3.next=ls4;
        ListNode ls5 = new ListNode(3);
        ls4.next=ls5;
        ls5.next=null;


        ls2 = sort(ls2);
        while(ls2!=null){
            System.out.println(ls2.val);
            ls2=ls2.next;
        }
    }

    public static ListNode sort(ListNode head){
        ListNode dummy = null;
        ListNode l = new ListNode(0);
        l.next=dummy;
        ListNode node = head;
        while(node!=null){
            ListNode temp = node.next;
            ListNode prev=null;
            while(dummy!=null && dummy.val<node.val){
                prev=dummy;
                dummy=dummy.next;
            }
            node.next=dummy;
            if(prev!=null){
                prev.next=node;
            }
            else{
                l.next=node;
            }
            node =temp;
            dummy=l.next;
            String test = "d";
            char[] word = test.substring(2,3+3).toCharArray();
            Arrays.sort(word);
            char[] word2 = test.substring(2,3+3).toCharArray();
            Arrays.sort(word);


        }
        return l.next;
    }

}
