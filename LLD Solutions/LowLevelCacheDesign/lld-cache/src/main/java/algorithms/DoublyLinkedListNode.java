package algorithms;


import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

 E element;
 DoublyLinkedListNode<E> prev;
 DoublyLinkedListNode<E> next;

 public DoublyLinkedListNode(E element){
     this.element =element;
     this.prev = null;
     this.next = null;
 }


}
