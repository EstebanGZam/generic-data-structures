package dataStructures.Heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements IHeap<T> {

	private final ArrayList<T> A;
	private int size;

	public Heap(ArrayList<T> array) {
		this.A = array;
		this.size = array.size();
		buildMaxHeap();
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
		if (l < A.size() && A.get(l).compareTo(A.get(i)) > 0) {
			largest = l;
		}
		if (r < A.size() && A.get(r).compareTo(A.get(largest)) > 0) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}

	@Override
	public void swap(int i, int j) {
		T temp = A.get(i);
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
}
