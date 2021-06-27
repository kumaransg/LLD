package DataStructures.LinkedList;

class Node {
    int value;
    Node next;
}

class LinkedListOperations{
   Node head;
    private void addNode(int value){
        if(head==null){
            head = new Node();
            head.value = value;
            return;
        }
        Node tmp = new Node();
        tmp.value= value;
        System.out.println("Adding new node"+tmp.value);
        tmp.next = head;
        head=tmp;
    }

    private void addNodeAtEnd(int value){
        if(head==null){
            head = new Node();
            head.value = value;
            return;
        }
        Node current = head;

        while(current.next!=null){
            current=current.next;
        }

        Node newNode = new Node();
        newNode.value = value;
        current.next = newNode;
    }

    private void removeFirstNode(){
        Node current =head;
        head=head.next;
        current.next=null;
    }

    private void removeNthNode(int value){
        Node previousNode = null;
        Node current = head;
        while(current.value != value){
            previousNode=current;
            current=current.next;
        }
        previousNode.next=current.next;
        current.next=null;
    }

    private void printList(){
        Node current =head;
        while(current!=null){
            System.out.print(current.value + "->");
            current=current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListOperations a =new LinkedListOperations();
        a.addNode(4);
        a.addNode(5);
        a.addNode(2);
        a.addNodeAtEnd(10);
        a.printList();
        System.out.println("****delteing Node now****");
        a.removeFirstNode();
        a.printList();
        System.out.println();
        a.removeNthNode(4);
        a.printList();

    }
}

/*
1->2->3->4

4->3->2->1

*/
