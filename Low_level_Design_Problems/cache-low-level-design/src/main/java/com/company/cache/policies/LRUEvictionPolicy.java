package com.company.cache.policies;

import com.company.algorithm.DoublyLinkedList;
import com.company.algorithm.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

	private final DoublyLinkedList<K> dll;
	private final Map<K, DoublyLinkedListNode<K>> nodeMap;

	public LRUEvictionPolicy() {
		this.nodeMap = new HashMap<>();
		this.dll = new DoublyLinkedList<>();
	}

	@Override
	public void keyAccessed(K key) {
		DoublyLinkedListNode<K> node;

		if (nodeMap.containsKey(key)) {
			node = nodeMap.get(key);
			dll.detachNode(node);
			dll.addNodeToLast(node);
		} else {
			node = dll.addElementToLast(key);
			nodeMap.put(key, node);
		}
	}

	@Override
	public K removeKey() {
		DoublyLinkedListNode<K> firstNode = dll.getFirstNode();
		if (firstNode == null) {
			return null;
		}
		dll.detachNode(firstNode);
		return firstNode.getElement();
	}
}
