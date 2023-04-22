package dataStructures.Hash;

public class ChainHash<K extends Comparable<K>, V> implements IHash<K, V> {
    private int length;
    private ComparableNode<K, V>[] list;

    public ChainHash(int length) {
        this.length = length;
        list = new ComparableNode[length];
    }

    public void insert(K key, V value) {
        int index = hash(key);
        ComparableNode<K, V> ComparableNode = new ComparableNode<K, V>(key, value);
        if (list[index] != null) {
            list[index].setPrev(ComparableNode);
            ComparableNode.setNext(list[index]);
        }
        list[index] = ComparableNode;
    }

    public V search(K key) {
        int index = hash(key);
        ComparableNode<K, V> ComparableNode = list[index];
        while (ComparableNode != null) {
            if (ComparableNode.getKey().compareTo(key) == 0) {
                return ComparableNode.getValue();
            }
            ComparableNode = ComparableNode.getNext();
        }
        return null;
    }

    public void delete(K key) {
        int index = hash(key);
        ComparableNode<K, V> ComparableNode = list[index];
        boolean found = false;
        while (ComparableNode != null && !found) {
            if (ComparableNode.getKey().compareTo(key) == 0) {
                if (ComparableNode.getPrev() == null) {
                    list[index] = ComparableNode.getNext();
                } else {
                    ComparableNode.getPrev().setNext(ComparableNode.getNext());
                }
                if (ComparableNode.getNext() != null) {
                    ComparableNode.getNext().setPrev(ComparableNode.getPrev());
                }
                found = true;
            } else {
                ComparableNode = ComparableNode.getNext();
            }
        }
    }

    public String print() {
        String msg = "";
        for (int i = 0; i < length; i++) {
            msg += "[ ";
            if (list[i] != null) {
                ComparableNode<K, V> ComparableNode = list[i];
                while (ComparableNode != null) {
                    if (ComparableNode.getNext() == null) {
                        msg += ComparableNode.getValue().toString() + ". ";
                    } else {
                        msg += ComparableNode.getValue().toString() + ", ";
                    }
                    ComparableNode = ComparableNode.getNext();
                }

            }
            msg += "]\n";

        }
        return msg;
    }

    public int hash(K key) {
        return key.hashCode() % length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ComparableNode<K, V>[] getList() {
        return list;
    }

    public void setList(ComparableNode<K, V>[] list) {
        this.list = list;
    }
}
