package dataStructures;

import dataStructures.Hash.Hash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTest {
	private Hash<Integer, String> hash;

	public void setUp1() {
		hash = new Hash<>(10);
		try {
			hash.insert(1, "Juan");
			hash.insert(2, "Esteban");
			hash.insert(3, "Manuel");
			hash.insert(4, "Oscar");
			hash.insert(5, "Diana");
		} catch (Exception e) {
		}
	}

	public void setUp2() {
		hash = new Hash<>(10);
	}

	@Test
	public void testIsEmpty() {
		setUp2();
		Assertions.assertTrue(hash.isEmpty());
	}

	@Test
	public void testInsertOneElement() {
		setUp2();
		try {
			hash.insert(1, "1");
		} catch (Exception e) {
		}
		Assertions.assertEquals(1, hash.size());
		Assertions.assertEquals("1", hash.search(1));

	}

	@Test
	public void testSearch() {
		setUp1();
		try {
			hash.insert(8, "8");
		} catch (Exception e) {
		}
		Assertions.assertEquals("8", hash.search(8));
	}

	@Test
	public void testDeleteOneElement() {
		setUp1();
		hash.delete(1);
		Assertions.assertNull(hash.search(1));
	}

}
