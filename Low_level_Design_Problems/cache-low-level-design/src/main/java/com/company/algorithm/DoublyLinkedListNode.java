package com.company.algorithm;

/**
 * Node structure for the Doubly Linked List.
 *
 * @param <Key> Type Of Key
 */
public class DoublyLinkedListNode<E> {

	private final E element;
	DoublyLinkedListNode<E> next;
	DoublyLinkedListNode<E> prev;

	public DoublyLinkedListNode(E element) {
		this.element = element;
		this.next = null;
		this.prev = null;
	}

	public E getElement() {
		return element;
	}

	public DoublyLinkedListNode<E> getNext() {
		return next;
	}

	public DoublyLinkedListNode<E> getPrev() {
		return prev;
	}
}


