package dataStructures.Hash;

import dataStructures.ComparableNode;

import java.util.ArrayList;
public class Hash<K extends Comparable<K>, V> implements IHash<K, V> {
	private int size;

	private final ArrayList<ComparableNode<K, V>> bucketArray;
	ComparableNode<K, V> deleted;

	public Hash(int size) {
		this.size = 0;
		bucketArray = new ArrayList<>();
		deleted = new ComparableNode<>(null, null);
		for (int i = 0; i < size; i++)
			bucketArray.add(null);
	}

	@Override
	public void insert(K key, V value) throws Exception {
		if (size() < bucketArray.size()) {
			for (int i = 0; i < bucketArray.size(); i++) {
				boolean located = false;
				int j = hash(key, i);
				if (bucketArray.get(j) == null) {
					bucketArray.set(j, new ComparableNode<>(key, value));
					this.size++;
					located = true;
				} else if (bucketArray.get(j).getKey().compareTo(key) == 0) {
					bucketArray.get(j).setElement(value);
					located = true;
				}
				if (located)
					return;
			}
		}
		throw new Exception("Hash table overflow: Maximum amount exceeded.");
	}

	@Override
	public V search(K key) {
		boolean stop = false;
		for (int i = 0; i < bucketArray.size() && !stop; i++) {
			int index = hash(key, i);
			ComparableNode<K, V> node = bucketArray.get(index);
			if (node == null) {
				stop = true;
			} else if (node != deleted && node.getKey().equals(key))
				return bucketArray.get(index).getElement();
		}
		return null;
	}

	@Override
	public void delete(K key) {
		boolean stop = false;
		for (int i = 0; i < bucketArray.size() && !stop; i++) {
			int index = hash(key, i);
			ComparableNode<K, V> node = bucketArray.get(index);
			if (node == null) {
				stop = true;
			} else if (node != deleted && node.getKey().equals(key)) {
				bucketArray.set(index, deleted);
				this.size--;
			}
		}
	}

	public String print() {
		StringBuilder msg = new StringBuilder("[ ");
		for (ComparableNode<K, V> node : bucketArray) {
			if (node != null && node != deleted)
				msg.append(node).append(", ");
		}
		return (msg.length() > 2 ? msg.substring(0, msg.length() - 2) : msg.substring(0, msg.length() - 1)) + " ]";
	}

	private int hash(K key, int i) {
		return (hash(key) + i) % bucketArray.size();
	}

	private int hash(K key) {
		int h = key.hashCode() % bucketArray.size();
		return (h < 0) ? -h : h;
	}

	// private int hash(K key, int i) {
	// int h = (h1(key) + i * h2(key)) % bucketArray.size();
	// return h < 0 ? -h : h;
	// }

	// private int h1(K key) {
	// return key.hashCode() % bucketArray.size();
	// }

	// private int h2(K key) {
	// return 1 + (key.hashCode() % (bucketArray.size() - 1));
	// }

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}
