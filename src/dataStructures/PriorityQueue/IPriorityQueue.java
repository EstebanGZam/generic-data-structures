package dataStructures.PriorityQueue;

public interface IPriorityQueue<K extends Comparable<K>, T> {
	public void insert(K key, T element);

	public T maximum();

	public T extractMax();

	public void increaseKey(int i, K key);

}
