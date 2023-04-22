package dataStructures.Queue;

import dataStructures.SimpleNode;
import dataStructures.Stack.Stack;
import exception.QueueException;

public class Queue<T> implements IQueue<T> {

	private SimpleNode<T> first;
	private SimpleNode<T> last;
	private int size = 0;

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(T item) throws QueueException {
		SimpleNode<T> newSimpleNode = new SimpleNode<>(item);
		if (isEmpty()) {
			first = newSimpleNode;
		} else {
			last.setNext(newSimpleNode);
		}
		last = newSimpleNode;
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
			SimpleNode<T> firstSimpleNode = first;
			first = (first == last) ? null : first.getNext();
			size--;
			return firstSimpleNode.getValue();
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
