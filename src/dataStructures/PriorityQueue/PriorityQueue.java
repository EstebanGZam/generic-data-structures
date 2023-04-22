package dataStructures.PriorityQueue;

import dataStructures.ComparableNode;

import java.util.ArrayList;

public class PriorityQueue<K extends Comparable<K>, V> implements IPriorityQueue<K, V> {

	private final ArrayList<ComparableNode<K, V>> A;

	public PriorityQueue() {
		this.A = new ArrayList<>();
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	@Override
	public V extractMax() {
		if (isEmpty()) {
			throw new IllegalStateException("");
		}
		ComparableNode<K, V> max = A.get(0);
		A.set(0, A.get(A.size() - 1));
		A.remove(A.size() - 1);
		maxHeapify(0);
		return max.getValue();
	}

	@Override
	public void insert(K key, V element) {
		A.add(new ComparableNode<>(key, element));
		increaseKey(A.size() - 1, key);
	}

	@Override
	public V maximum() {
		return A.get(0).getValue();
	}

	@Override
	public void increaseKey(int i, K key) {
		if (key.compareTo(A.get(i).getKey()) < 0) {
			throw new IllegalStateException("");
		}
		A.get(i).setKey(key);
		while (i > 0 && A.get(parent(i)).getKey().compareTo(A.get(i).getKey()) < 0) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	public void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < A.size() && A.get(l).getKey().compareTo(A.get(i).getKey()) > 0) {
			largest = l;
		}
		if (r < A.size() && A.get(r).getKey().compareTo(A.get(largest).getKey()) > 0) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}

	public void swap(int i, int j) {
		ComparableNode<K, V> temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

	public int size() {
		return this.A.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}