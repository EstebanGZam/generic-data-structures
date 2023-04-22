package model;


import dataStructures.Stack.Stack;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {

	private Stack<String> stack;

	@Before
	public void setUp1() {
		stack = new Stack<>();
	}

	@Before
	public void setUp2() {
		try {
			stack = new Stack<>();
			stack.push("Hello world");
			stack.push("Bye world");
		} catch (Exception e) {

		}
	}

	@Test
	public void pushTwoObjectsToEmptyStackCheck() {
		try {
			setUp1();
			stack.push("Hello world");
			stack.push("Bye world");
		} catch (Exception e) {

		}
		assertEquals(2, stack.size());
	}

	@Test
	public void testPop() {
		try {
			stack.pop();
			assertEquals(1, stack.size());
			stack.pop();
			assertEquals(0, stack.size());
			assertNull(stack);
		} catch (Exception e) {

		}
	}

}
