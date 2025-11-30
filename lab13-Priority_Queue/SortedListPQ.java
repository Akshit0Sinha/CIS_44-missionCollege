import java.util.LinkedList;

// --- 4. Implementation 2: Sorted List (LinkedList) ---
// Insert: O(n) | RemoveMin: O(1)
class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
	private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

	@Override
	public void insert(K key, V value) {
		MyEntry<K, V> newEntry = new MyEntry<>(key, value);
		// TODO: Find the correct insertion point to maintain sorted order by key (O(n))
		// Hint: Iterate and use list.add(index, newEntry) when list.get(index) >
		// newEntry
		int i = 0;
		for (; i < list.size(); i++) {
			if (list.get(i).compareTo(newEntry) > 0) {
				list.add(i, newEntry);
				return;
			}
		}
		// Default insert at end if it's the largest
		list.addLast(newEntry);
	}

	@Override
	public boolean isEmpty() { return list.isEmpty(); }

	@Override
	public MyEntry<K, V> min() {
		return isEmpty() ? null : list.getFirst(); // O(1)
	}

	@Override
	public MyEntry<K, V> removeMin() {
		return isEmpty() ? null : list.removeFirst(); // O(1)
	}
}
