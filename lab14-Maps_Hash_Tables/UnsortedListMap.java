import java.util.ArrayList;

// --- 3. Implementation: Unsorted List Map ---
public class UnsortedListMap<K, V> implements MapADT<K, V> {
	private ArrayList<Entry<K, V>> list = new ArrayList<>();

	private int findEntryIndex(K key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public V get(K key) {
		int i = findEntryIndex(key);
		return i != -1 ? list.get(i).getValue() : null;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// O(n) put method
	@Override
	public V put(K key, V value) {
		int i = findEntryIndex(key);
		if (i != -1) { // Key exists → update value
			return list.get(i).setValue(value);
		}
		list.add(new Entry<>(key, value)); // Key not found → add new entry
		return null;
	}

	@Override
	public V remove(K key) {
		int i = findEntryIndex(key);
		if (i != -1) {
			V oldValue = list.get(i).getValue();
			list.remove(i);
			return oldValue;
		}
		return null;
	}

	@Override
	public int size() { return list.size(); }
}