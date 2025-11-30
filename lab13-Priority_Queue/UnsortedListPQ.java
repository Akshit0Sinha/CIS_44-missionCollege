import java.util.LinkedList;

// --- 3. Implementation 1: Unsorted List (LinkedList) ---
// Insert: O(1) | RemoveMin: O(n)
class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
	private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

	@Override
	public void insert(K key, V value) {
		list.addLast(new MyEntry<>(key, value)); // O(1)
	}

	@Override
	public boolean isEmpty() { return list.isEmpty(); }

	@Override
	public MyEntry<K, V> min() {
		if (isEmpty()) {
			return null;
		}
		MyEntry<K, V> minEntry = list.getFirst();
		for (MyEntry<K, V> entry : list) {
			if (entry.compareTo(minEntry) < 0) {
				minEntry = entry;
			}
		}
		return minEntry;
	}

	@Override
	public MyEntry<K, V> removeMin() {
		if (isEmpty()) {
			return null;
		}
		// TODO: Find the minimum Entry by key
		MyEntry<K, V> minEntry = min();

		// TODO: Remove the min Entry from the list (This is also O(n) for LinkedList)
		list.remove(minEntry);
		return minEntry;
	}
}
