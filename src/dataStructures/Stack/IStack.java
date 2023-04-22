package dataStructures.Stack;

import exception.StackException;

public interface IStack<T> {

	public boolean isEmpty();

	public void push(T item) throws StackException;

	public T top() throws StackException;

	public T pop() throws StackException;

}