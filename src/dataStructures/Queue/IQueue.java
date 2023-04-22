package dataStructures.Queue;

import exception.QueueException;

public interface IQueue<T> {

	public boolean isEmpty();

	public void enqueue(T item) throws QueueException;

	public T front() throws QueueException;

	public T dequeue() throws QueueException;

}
