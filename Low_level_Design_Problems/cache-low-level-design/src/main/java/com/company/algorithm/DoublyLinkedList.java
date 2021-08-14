package com.company.algorithm;

import com.company.algorithm.exception.InvalidElementException;

public class DoublyLinkedList<E> {

	private DoublyLinkedListNode<E> head;
	private DoublyLinkedListNode<E> tail;

	public DoublyLinkedList() {
		this.head = new DoublyLinkedListNode<>(null);
		this.tail = new DoublyLinkedListNode<>(null);

		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Helper method is detach a node from {@DoubleLinkedList},
	 * but the node may still be present in the memory.
	 *
	 * @param node
	 */
	public void detachNode(DoublyLinkedListNode<E> node) {
		// simply shifting the pointers
		if (node != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	/**
	 * Helper method to add the input node as the last of the {@DoubleLinkedList}
	 *
	 * @param node
	 */
	public void addNodeToLast(DoublyLinkedListNode<E> node) {
		node.prev = this.tail.prev;
		this.tail.prev.next = node;

		node.next = this.tail;
		this.tail.prev = node;
	}

	/**
	 * Helper method to add the element as the last node in this {@DoubleLinkedList}.
	 *
	 * @param element
	 * @return DoubleLinkedList<E>
	 */
	public DoublyLinkedListNode<E> addElementToLast(E element) {
		if (element == null) {
			throw new InvalidElementException("Null element cannot be added in list.");
		}

		DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
		this.addNodeToLast(node);

		return node;
	}

	/**
	 * Helper method to check if this {@DoubleLinkedList} is empty.
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return this.head.next == tail;
	}

	/**
	 * Method to get the first node in the {@DoubleLinkedList}
	 *
	 * @return
	 */
	public DoublyLinkedListNode<E> getFirstNode() {
		if (isEmpty())
			return null;

		return this.head.next;
	}

	/**
	 * Method to get the last node in the {@DoubleLinkedList}
	 *
	 * @return
	 */
	public DoublyLinkedListNode<E> getLastNode() {
		if (isEmpty())
			return null;

		return this.tail.prev;
	}

}
