package dataStructures.Heap;

import java.util.ArrayList;

public class Heap<K extends Comparable<K>, T> implements IHeap<K, T>, IPriorityQueue<K, T> {

	private ArrayList<Node<K, T>> A;
	private int size;

	public Heap(ArrayList<Node<K, T>> array) {
		this.A = array;
		this.size = array.size();
		buildMaxHeap();
	}

	public Heap() {
		this.A = new ArrayList<>();
		this.size = 0;
	}

	@Override
	public int parent(int i) {
		return (i - 1) / 2;
	}

	@Override
	public int left(int i) {
		return 2 * i + 1;
	}

	@Override
	public int right(int i) {
		return 2 * i + 2;
	}

	@Override
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

	@Override
	public void swap(int i, int j) {
		Node<K, T> temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

	@Override
	public void buildMaxHeap() {
		for (int i = A.size() / 2 - 1; i >= 0; i--) {
			maxHeapify(i);
		}
	}

	@Override
	public void heapsort() {
		buildMaxHeap();
		for (int i = A.size() - 1; i > 0; i--) {
			swap(0, i);
			this.size--;
			maxHeapify(0);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public String print() {
		String heapContent = "[ ";
		for (int i = 0; i < size(); i++) {
			heapContent += A.get(i).getElement();
			heapContent += (i == size() - 1) ? "" : ", ";
		}
		heapContent += " ]";
		return heapContent;
	}

	@Override
	public T extractMax() {
		if (isEmpty()) {
			throw new IllegalStateException("");
		}
		Node<K, T> max = A.get(0);
		A.set(0, A.get(A.size() - 1));
		A.remove(A.size() - 1);
		this.size--;
		maxHeapify(0);
		return max.getElement();
	}

	@Override
	public void insert(Node<K, T> element) {
		A.add(element);
		this.size++;
		increaseKey(A.size() - 1, element.getKey());
	}

	@Override
	public T maximum() {
		return A.get(0).getElement();
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
}