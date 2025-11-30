// --- 1. Entry ADT ---
class MyEntry<K extends Comparable<K>, V> implements Comparable<MyEntry<K, V>> {
	private K key;
	private V value;

	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(MyEntry<K, V> other) {
		return this.key.compareTo(other.key);
	}

	public K getKey() { return key; }

	public V getValue() { return value; }

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
