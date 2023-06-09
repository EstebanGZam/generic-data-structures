package dataStructures.Heap;

public interface IHeap<T extends Comparable<T>> {
	public void maxHeapify(int i);

	public void buildMaxHeap();

	public void heapsort();

	public void swap(int i, int j);


	public int left(int i);

	public int right(int i);

}
