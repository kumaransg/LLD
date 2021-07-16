package algorithms;

import cache.exceptions.InvalidElementException;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList(){
        first = new DoublyLinkedListNode<E>(null);
        last = new DoublyLinkedListNode<E>(null);
        first.next = last;
        last.prev = first;
    }

  public void detachNode(DoublyLinkedListNode<E> node){

      if(node != null){
          node.prev.next = node.next;
          node.next.prev = node.prev;
      }
  }

  public DoublyLinkedListNode<E> addElementAtLast(E element) {

      if(element == null)throw new InvalidElementException();

      DoublyLinkedListNode<E> node = new DoublyLinkedListNode(element);
      DoublyLinkedListNode tailPrev = last.prev;
      tailPrev.next = node;
      node.next = last;
      last.prev = node;
      node.prev = tailPrev;
      return node;
  }


  public boolean isItemPresent(){
     return first.next!= last;
  }

  public DoublyLinkedListNode<E> getFirstNode(){

        if(isItemPresent()){
            return first.next;
        }else{
            return null;
        }
  }

  public DoublyLinkedListNode<E> getLastNode(){

     if(isItemPresent()){
         return last.prev;
     }else{
         return null;
     }
  }

}
