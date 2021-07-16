package LinkedList;

import java.util.Scanner;

/**
 * Given two integers represented as linked lists, 'add' them together,
 * producing a new linked list representation of the sum.
 *
 * For example:
 *
 * list1: 1 -> 2 -> 3
 * list2:      5 -> 6
 * sum:   1 -> 7 -> 9
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next=null;
    }
}
class Node{
    int carry;
    ListNode node;
    public Node(ListNode node, int carry){
        this.node = node;
        this.carry = carry;
    }
}

public class sumLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if(len1<len2)
            l1 = addPadding(l1,len2-len1);
        if(len2<len1)
            l2 = addPadding(l2,len1-len2);

        Node n = add(l1,l2);
        l1 = n.node;
        if(n.carry!=0)
            l1 = addBefore(n.node,n.carry);
        return l1;
    }
    private static Node add(ListNode l1, ListNode l2){
        if(l1==null)
            return new Node(null,0);
        Node n = add(l1.next,l2.next);

        int val = l1.val+l2.val+n.carry;

        ListNode newNode = new ListNode(val%10);
        newNode.next = n.node;
        n.carry = val/10;
        n.node=newNode;
        return n;

    }
    private static ListNode addBefore(ListNode l, int value){
        ListNode lnode = new ListNode(value);
        lnode.next=l;
        return lnode;
    }
    private static ListNode addPadding(ListNode l, int count){
        while(count>0){
            l = addBefore(l,0);
            count--;
        }
        return l;
    }
    private static int getLen(ListNode l){
        int count =0;
        while(l!=null)
        {
            count++;
            l=l.next;
        }
        return count;
    }

    private static void formLinkedList(ListNode root, int len1){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < len1; i++)
        {
            int v = i+1;
            System.out.println("Add Node "+v+" value:");
            root.next=new ListNode(in.nextInt());
            root=root.next;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of the first linked list");
        int len1 = in.nextInt();
        ListNode root1=new ListNode(-1),root=root1;
        formLinkedList(root1,len1);
        root1=root.next;

        System.out.println("Enter length of the second linked list");
        int len2 = in.nextInt();
        ListNode root2=new ListNode(-1);
        root=root2;
        formLinkedList(root2,len2);
        root2=root.next;

        ListNode sum = addTwoNumbers(root1,root2);

        while(sum!=null){
            System.out.print(sum.val);
            if(sum.next!=null){
                System.out.print(" -> ");
            }
            sum=sum.next;
        }
    }
}
