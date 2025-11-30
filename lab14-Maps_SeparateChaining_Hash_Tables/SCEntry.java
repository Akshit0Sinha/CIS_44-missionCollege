public class SCEntry<K, V> {
	private K key;
	private V value;

	public SCEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V value) {
		V old = this.value;
		this.value = value;
		return old;
	}

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
