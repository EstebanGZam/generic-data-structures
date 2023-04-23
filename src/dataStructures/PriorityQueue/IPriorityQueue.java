package dataStructures.PriorityQueue;

public interface IPriorityQueue<K extends Comparable<K>, T> {
	void insert(K key, T element);

	T maximum();

	T extractMax();

	void increaseKey(int i, K key);

}
