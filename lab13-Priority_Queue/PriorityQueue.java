// --- 2. Common Interface ---
interface PriorityQueue<K extends Comparable<K>, V> {
	void insert(K key, V value);

	boolean isEmpty();

	MyEntry<K, V> min();

	MyEntry<K, V> removeMin();
}