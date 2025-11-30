import java.util.ArrayList;
import java.util.LinkedList;

public class SeparateChainingHashMap<K, V> implements SCMapADT<K, V> {
	private ArrayList<LinkedList<SCEntry<K, V>>> table;
	private int size = 0;
	private final int N = 11;

	public SeparateChainingHashMap() {
		table = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			table.add(new LinkedList<SCEntry<K, V>>());
		}
	}

	@Override
	public V get(K key) {
		int h = hash(key);
		LinkedList<SCEntry<K, V>> bucket = table.get(h);

		for (SCEntry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode() % N);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		int h = hash(key);
		LinkedList<SCEntry<K, V>> bucket = table.get(h);

		for (SCEntry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry.setValue(value);
			}
		}

		bucket.addFirst(new SCEntry<>(key, value));
		size++;
		return null;
	}

	@Override
	public V remove(K key) {
		int h = hash(key);
		LinkedList<SCEntry<K, V>> bucket = table.get(h);

		SCEntry<K, V> toRemove = null;
		for (SCEntry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				toRemove = entry;
				break;
			}
		}

		if (toRemove != null) {
			V value = toRemove.getValue();
			bucket.remove(toRemove);
			size--;
			return value;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
}
