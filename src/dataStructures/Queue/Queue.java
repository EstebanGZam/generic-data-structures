package dataStructures.Queue;

import dataStructures.Node;
import dataStructures.Stack.Stack;
import exception.QueueException;

public class Queue<T> implements IQueue<T> {

	private Node<T> first;
	private Node<T> last;
	private int size = 0;

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(T item) throws QueueException {
		Node<T> newNode = new Node<>(item);
		if (isEmpty()) {
			first = newNode;
		} else {
			last.setNext(newNode);
		}
		last = newNode;
		size++;
	}

	@Override
	public T front() throws QueueException {
		if (!isEmpty()) {
			return first.getValue();
		} else {
			throw new QueueException("QueueException on front: Empty queue");
		}
	}

	@Override
	public T dequeue() throws QueueException {
		if (!isEmpty()) {
			Node<T> firstNode = first;
			first = (first == last) ? null : first.getNext();
			size--;
			return firstNode.getValue();
		} else {
			throw new QueueException("QueueException on dequeue: Empty queue");
		}
	}

	public void reverseQueue() {
		Stack<T> stack = new Stack<>();
		while (!isEmpty()) {
			stack.push(dequeue());
		}
		while (!stack.isEmpty()) {
			enqueue(stack.top());
			stack.pop();
		}
	}

	public int size() {
		return size;
	}

}
