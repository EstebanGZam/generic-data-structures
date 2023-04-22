package dataStructures;

public class SimpleNode<T> {
	T value;
	SimpleNode<T> next;

	public SimpleNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public SimpleNode<T> getNext() {
		return next;
	}

	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}

}
