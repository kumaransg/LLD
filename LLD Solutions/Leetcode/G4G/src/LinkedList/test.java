package LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Before
    public void init() {
        compareLinkedList list = new compareLinkedList();
    }

    @Test
    public void checkSortedOrder() {

        compareLinkedList.insert("Aditi","Ja");
        compareLinkedList.insert("Ajay","Go");

        List<String> ls = new ArrayList<>();

        while(compareLinkedList.head!=null){
            ls.add(compareLinkedList.head.name.firstName+" "+compareLinkedList.head.name.lastName);
            compareLinkedList.head =compareLinkedList.head.next;
        }
        Assert.assertEquals("Ajay Go", ls.get(0));
    }

    @Test
    public void checkSortedOrder2() {

        compareLinkedList.insert("Zebb","Aerotrek");
        compareLinkedList.insert("Trever","Bose");

        List<String> ls = new ArrayList<>();

        while(compareLinkedList.head!=null){
            ls.add(compareLinkedList.head.name.firstName+" "+compareLinkedList.head.name.lastName);
            compareLinkedList.head =compareLinkedList.head.next;
        }
        Assert.assertEquals("Trever Bose", ls.get(1));
    }
    @Test
    public void checkNull() {

        compareLinkedList.insert(" "," ");

        List<String> ls = new ArrayList<>();

        while(compareLinkedList.head!=null){
            ls.add(compareLinkedList.head.name.firstName+" "+compareLinkedList.head.name.lastName);
            System.out.println(compareLinkedList.head.name.firstName+" "+compareLinkedList.head.name.lastName);
            compareLinkedList.head =compareLinkedList.head.next;
        }
        Assert.assertEquals(0, ls.size());
    }

    @Test
    public void checkDuplicates() {

        compareLinkedList.insert("Trever","Bose");
        compareLinkedList.insert("Zebb","Aerotrek");
        compareLinkedList.insert("Trever","Bose");

        List<String> ls = new ArrayList<>();
        //compareLinkedList.ListNode node = compareLinkedList.head;
        while(compareLinkedList.head!=null){
            ls.add(compareLinkedList.head.name.firstName+" "+compareLinkedList.head.name.lastName);
            compareLinkedList.head = compareLinkedList.head.next;
        }
        Assert.assertEquals("Trever Bose", ls.get(1));
        Assert.assertEquals("Trever Bose", ls.get(2));
        Assert.assertEquals("Zebb Aerotrek", ls.get(0));
    }


    @Test
    public void checkFirstName() {


        compareLinkedList.insert("ABC","Aerotrek");

        List<String> ls = new ArrayList<>();
        compareLinkedList.ListNode node = compareLinkedList.head;
        while(node!=null){
            ls.add(node.name.firstName+" "+node.name.lastName);
            node = node.next;
        }
        Assert.assertEquals("ABC Aerotrek", ls.get(0));
    }

    @Test
    public void checkCounter() {

        compareLinkedList.insert("Aditi","Ja");
        compareLinkedList.insert("Ajay","Go");
        compareLinkedList.insert("ABC","Aerotrek");
        compareLinkedList.insert("Trever","Bose");
        compareLinkedList.insert("Zebb","Aerotrek");
        compareLinkedList.insert("Trever","Bose");

        Assert.assertEquals(6, compareLinkedList.counter());
    }


}
