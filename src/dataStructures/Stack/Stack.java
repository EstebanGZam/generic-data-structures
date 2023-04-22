package dataStructures.Stack;

import dataStructures.Node;
import exception.StackException;

public class Stack<T> implements IStack<T> {

	private Node<T> top;
	private int size = 0;

	@Override
	public void push(T value) {
		Node<T> node = new Node<>(value);
		if (!isEmpty()) {
			node.setNext(top);
		}
		top = node;
		size++;
	}

	@Override
	public T pop() throws StackException {
		if (!isEmpty()) {
			T aux = top.getValue();
			top = top.getNext();
			size--;
			return aux;
		} else {
			throw new StackException("Empty stack");
		}
	}

	@Override
	public T top() throws StackException {
		if (!isEmpty()) {
			return top.getValue();
		} else {
			throw new StackException("Empty stack");
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return this.size;
	}

}
