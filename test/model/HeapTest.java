package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataStructures.Heap.Heap;
import dataStructures.Heap.IPriorityQueue;
import dataStructures.Heap.Node;
import org.junit.Test;

import java.util.ArrayList;

public class HeapTest {
	private Heap<Integer, Integer> heap1;
	private IPriorityQueue<Integer, String> heap2;

	public void setupStage1() {
		Integer[] array = {5, 7, 10, 1, 4, 6, 8, 2, 9, 12};
		ArrayList<Node<Integer, Integer>> list = new ArrayList<>();
		for (Integer number : array) {
			list.add(new Node<>(number, number));
		}
		heap1 = new Heap<>(list);
	}

	public void setupStage2() {
		this.heap2 = new Heap<>();
	}

	public void setupStage3() {
		this.heap2 = new Heap<>();
		heap2.insert(new Node<>(1, "Esteban"));
		heap2.insert(new Node<>(2, "Miguel"));
		heap2.insert(new Node<>(3, "Alexandro"));
		heap2.insert(new Node<>(3, "Juan"));
		heap2.insert(new Node<>(3, "Mario"));
		heap2.insert(new Node<>(5, "Steven"));
		heap2.insert(new Node<>(3, "Andres"));
	}

	@Test
	public void testBuildMaxHeap() {
		setupStage1();
		String expected = "[ 12, 9, 10, 5, 7, 6, 8, 2, 1, 4 ]";
		assertEquals(expected, heap1.print());
	}

	@Test
	public void testHeapSort() {
		setupStage1();
		heap1.heapsort();
		assertTrue(10 == heap1.maximum());
	}

	@Test
	public void testEmpty() {
		setupStage2();
		assertTrue(heap2.isEmpty());
	}

	@Test
	public void testInsert() {
		setupStage3();
		assertTrue(7 == heap2.size());
		// String expected = "[ Steven, Alexandro, Juan, Andres, Miguel, Esteban ]";
		assertEquals("Steven", heap2.extractMax());
		assertEquals("Alexandro", heap2.extractMax());
		assertEquals("Juan", heap2.extractMax());
		assertEquals("Mario", heap2.extractMax());
		assertEquals("Andres", heap2.extractMax());
		assertEquals("Miguel", heap2.extractMax());
		assertEquals("Esteban", heap2.extractMax());
		assertTrue(heap2.isEmpty());
	}

}
