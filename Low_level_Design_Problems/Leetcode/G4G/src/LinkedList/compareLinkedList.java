package LinkedList;

public class compareLinkedList {
    static ListNode head =null;//= new ListNode("A","Z");

    public static class Names {
        String firstName;
        String lastName;
        public Names (String firstName, String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }
    }

    public static class ListNode {
        Names name;
        ListNode next;
        ListNode(String firstName, String lastName) {
            this.name = new Names(firstName,lastName);
            this.next=null;
        }
    }

    public static void insert(String firstName, String lastName){
        if(firstName.trim().length()==0 && lastName.trim().length()==0) return;
        ListNode toCheck = new ListNode(firstName,lastName);
        ListNode node = new ListNode("",""),root=node;

        if(head==null){
            head = toCheck;
            return;
        }

        node.next=head;
        while(node!=null && node.next!=null){
            int result = compareTo(toCheck.name, node.next.name);
            if (result < 0) {
                toCheck.next = node.next;
                node.next = toCheck;
                break;
            }
            node=node.next;
        }

        if(node.next==null)
            node.next=toCheck;
        head=root.next;
    }

    public static int counter(){
        ListNode root = head;
        int count=0;
        while(root!=null){
            root=root.next;
            count++;
        }
        return count;
    }
    public static int compareTo(Names toCheck, Names name){
        if(name.lastName.equals(toCheck.lastName)){
            return toCheck.firstName.compareTo(name.firstName);
        }
        return toCheck.lastName.compareTo(name.lastName);
    }

    public static void main(String args[]){

        String[] names = new String[]{"Ajay Goel", "Aditi Jalkote","Boy Goel","Aa BB","Aa BB","ZZ ZZ"," "};
        //String[] names = new String[]{null};
        for(String name: names)
        {
            name = name.trim();
            if(name==null || name.length()==0) continue;
            String splitName[] = name.split(" ");
            insert(splitName[0],splitName[1]);
        }

        int counter = counter();

        //ListNode check = head;
        while(head!=null){
            System.out.println(head.name.firstName +"***"+ head.name.lastName);
            head=head.next;
        }
    }
}

