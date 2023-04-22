package model;

import static org.junit.jupiter.api.Assertions.*;

import dataStructures.Hash.ChainHash;
import org.junit.jupiter.api.Test;

public class ChainHashTest {

	private ChainHash<Integer, String> hashTable;

	public void setUp1() {
		hashTable = new ChainHash<>(10);
		hashTable.insert(1, "1");
		hashTable.insert(2, "2");
		hashTable.insert(3, "3");
		hashTable.insert(4, "4");
		hashTable.insert(5, "5");
	}

	public void setUp2() {
		hashTable = new ChainHash<>(10);
	}

	@Test
	public void testInsertOneElement() {
		setUp2();
		hashTable.insert(1, "1");
		assertEquals("1", hashTable.search(1));
	}

	@Test
	public void testDeleteOneElement() {
		setUp1();
		hashTable.delete(1);
		assertNull(hashTable.search(1));
	}

}
