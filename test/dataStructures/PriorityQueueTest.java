package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataStructures.PriorityQueue.PriorityQueue;
import org.junit.Test;

public class PriorityQueueTest {
	private PriorityQueue<Integer, String> priorityQueue1;

	public void setupStage1() {
		this.priorityQueue1 = new PriorityQueue<>();
	}

	public void setupStage3() {
		this.priorityQueue1 = new PriorityQueue<>();
		priorityQueue1.insert(1, "Esteban");
		priorityQueue1.insert(2, "Miguel");
		//  priorityQueue1.insert(3, "Alexandro");
		//	priorityQueue1.insert(3, "Juan");
		priorityQueue1.insert(3, "Mario");
		priorityQueue1.insert(5, "Steven");
	}

	@Test
	public void testEmpty() {
		setupStage1();
		assertTrue(priorityQueue1.isEmpty());
	}

	@Test
	public void testInsert() {
		setupStage3();
		assertEquals(6, priorityQueue1.size());
		// String expected = "[ Steven, Alexandro, Juan, Andres, Miguel, Esteban ]";
		assertEquals("Steven", priorityQueue1.extractMax());
		// assertEquals("Alexandro", priorityQueue1.extractMax());
		// assertEquals("Juan", priorityQueue1.extractMax());
		assertEquals("Mario", priorityQueue1.extractMax());
		assertEquals("Miguel", priorityQueue1.extractMax());
		assertEquals("Esteban", priorityQueue1.extractMax());
		assertTrue(priorityQueue1.isEmpty());
	}

}
