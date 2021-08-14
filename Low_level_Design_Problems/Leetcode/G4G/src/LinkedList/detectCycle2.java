package LinkedList;

public class detectCycle2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]){
        ListNode ls2 = new ListNode(3);
        ListNode ls3 = new ListNode(2);
        ls2.next =ls3;
        ListNode ls4 = new ListNode(0);
        ls3.next=ls4;
        ListNode ls5 = new ListNode(-4);
        ls4.next=ls5;
        ls5.next=ls3;

        ls2 = cycle(ls2);
        System.out.println(ls2.val);
    }

    public static ListNode cycle(ListNode ls) {
        ListNode firstPointer =ls;
        ListNode secondPointer =ls;
        boolean cycle = false;
        while(firstPointer!=null && secondPointer!=null){
            firstPointer=firstPointer.next;
            if(secondPointer.next==null) return null;
            secondPointer=secondPointer.next.next;
            if(firstPointer==secondPointer){
                cycle=true;
                break;
            }
        }
        if(!cycle) return null;
        firstPointer=ls;
        while(firstPointer!=secondPointer){
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next;
        }
        return firstPointer;
    }
}
