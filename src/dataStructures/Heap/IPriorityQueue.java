package dataStructures.Heap;

public interface IPriorityQueue<K extends Comparable<K>, T> {
	public void insert(Node<K, T> element);

	public T maximum();

	public T extractMax();

	public void increaseKey(int i, K key);

	public int size();

	public String print();

	public boolean isEmpty();

}
