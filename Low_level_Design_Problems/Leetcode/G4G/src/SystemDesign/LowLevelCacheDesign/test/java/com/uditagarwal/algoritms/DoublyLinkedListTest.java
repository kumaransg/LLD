//package SystemDesign.LowLevelCacheDesign.test.java.com.uditagarwal.algoritms;
//
//import com.google.common.collect.ImmutableList;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//class DoublyLinkedListTest {
//
//    @Test
//    void testDLLAddition() {
//        com.uditagarwal.algoritms.DoublyLinkedListNode<Integer> node1 = new com.uditagarwal.algoritms.DoublyLinkedListNode<>(1);
//        com.uditagarwal.algoritms.DoublyLinkedListNode<Integer> node2 = new com.uditagarwal.algoritms.DoublyLinkedListNode<>(2);
//        com.uditagarwal.algoritms.DoublyLinkedListNode<Integer> node3 = new com.uditagarwal.algoritms.DoublyLinkedListNode<>(3);
//        com.uditagarwal.algoritms.DoublyLinkedListNode<Integer> node4 = new com.uditagarwal.algoritms.DoublyLinkedListNode<>(4);
//
//        com.uditagarwal.algoritms.DoublyLinkedList<Integer> dll = new com.uditagarwal.algoritms.DoublyLinkedList<>();
//
//        dll.addNodeAtLast(node1);
//        verifyDLL(dll, ImmutableList.of(1));
//
//        dll.addNodeAtLast(node2);
//        verifyDLL(dll, ImmutableList.of(1, 2));
//
//        dll.addNodeAtLast(node3);
//        verifyDLL(dll, ImmutableList.of(1, 2, 3));
//
//        dll.addNodeAtLast(node4);
//        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4));
//
//        dll.addElementAtLast(5);
//        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));
//    }
//
//    @Test
//    void testDLLNodeDetachment() {
//        com.uditagarwal.algoritms.DoublyLinkedList<Integer> dll = new com.uditagarwal.algoritms.DoublyLinkedList<>();
//
//        DoublyLinkedListNode<Integer> node1 = dll.addElementAtLast(1);
//        DoublyLinkedListNode<Integer> node2 = dll.addElementAtLast(2);
//        DoublyLinkedListNode<Integer> node3 = dll.addElementAtLast(3);
//        DoublyLinkedListNode<Integer> node4 = dll.addElementAtLast(4);
//        DoublyLinkedListNode<Integer> node5 = dll.addElementAtLast(5);
//
//        verifyDLL(dll, ImmutableList.of(1, 2, 3, 4, 5));
//
//        dll.detachNode(node1);
//        verifyDLL(dll, ImmutableList.of(2, 3, 4, 5));
//
//        dll.detachNode(node5);
//        verifyDLL(dll, ImmutableList.of(2, 3, 4));
//
//        dll.detachNode(node3);
//        verifyDLL(dll, ImmutableList.of(2, 4));
//
//        dll.detachNode(null);
//        verifyDLL(dll, ImmutableList.of(2, 4));
//    }
//
//    void verifyDLL(DoublyLinkedList<Integer> dll, List<Integer> expectedListElements) {
//        assertEquals(expectedListElements.get(expectedListElements.size() - 1), dll.getLastNode().getElement());
//        assertEquals(expectedListElements.get(0), dll.getFirstNode().getElement());
//
//        DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();
//        for (Integer expectedListElement : expectedListElements) {
//            assertNotNull(currentNode);
//            assertEquals(expectedListElement, currentNode.getElement());
//            currentNode = currentNode.getNext();
//        }
//        assertNull(currentNode.next);
//    }
//}
