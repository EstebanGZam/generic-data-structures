package dataStructures.Heap;

public class Node<K extends Comparable<K>, T> {
	private K key;
	private T element;

	public Node(K key, T element) {
		this.key = key;
		this.element = element;
	}

	public K getKey() {
		return key;
	}

	public T getElement() {
		return element;
	}

	public void setKey(K key) {
		this.key = key;
	}
}
