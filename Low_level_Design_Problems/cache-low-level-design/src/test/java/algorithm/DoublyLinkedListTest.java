package algorithm;

import com.company.algorithm.DoublyLinkedList;
import com.company.algorithm.DoublyLinkedListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DoublyLinkedListTest {

	DoublyLinkedList<Integer> dll;

	@BeforeEach
	void setup() {
		dll = new DoublyLinkedList<>();
	}

	@Test
	void test_doublyLinkedListAddNode() {

		// Given
		DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
		DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
		DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
		DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

		// When, then
		dll.addNodeToLast(node1);
		verifyDll(dll, Collections.unmodifiableList(List.of(1)));

		// When, then
		dll.addNodeToLast(node2);
		verifyDll(dll, Collections.unmodifiableList(List.of(1, 2)));

		// When, then
		dll.addNodeToLast(node3);
		verifyDll(dll, Collections.unmodifiableList(List.of(1, 2, 3)));

		// When, then
		dll.addNodeToLast(node4);
		verifyDll(dll, Collections.unmodifiableList(List.of(1, 2, 3, 4)));
	}

	@Test
	void test_doublyLinkedListDetachNode() {

		// Given
		DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
		DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
		DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
		DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

		dll.addNodeToLast(node1);
		dll.addNodeToLast(node2);
		dll.addNodeToLast(node3);
		dll.addNodeToLast(node4);

		// then
		verifyDll(dll, Collections.unmodifiableList(List.of(1, 2, 3, 4)));

		// when, then
		dll.detachNode(node1);
		verifyDll(dll, Collections.unmodifiableList(List.of(2, 3, 4)));

		// when, then
		dll.detachNode(node3);
		verifyDll(dll, Collections.unmodifiableList(List.of(2, 4)));

		// when, then
		dll.detachNode(null);
		verifyDll(dll, Collections.unmodifiableList(List.of(2, 4)));

	}

	private void verifyDll(DoublyLinkedList<Integer> dll, List<Integer> unmodifiableList) {
		assertEquals(dll.getFirstNode().getElement(), unmodifiableList.get(0));
		assertEquals(dll.getLastNode().getElement(), unmodifiableList.get(unmodifiableList.size() - 1));

		DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();

		for (Integer element : unmodifiableList) {
			assertEquals(element, currentNode.getElement());
			currentNode = currentNode.getNext();
		}
	}
}
