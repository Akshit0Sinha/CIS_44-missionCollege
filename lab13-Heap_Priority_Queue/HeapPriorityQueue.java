import java.util.ArrayList;

// --- Heap Implementation ---
public class HeapPriorityQueue<K extends Comparable<K>> {
	private ArrayList<K> heap = new ArrayList<>();

	private void downheap(int j) {
		// TODO: While j has left child...
		while (left(j) < heap.size()) {
			int left = left(j);
			int right = right(j);
			int smallChild = left;

			if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) < 0) {
				smallChild = right;
			}

			if (heap.get(j).compareTo(heap.get(smallChild)) <= 0) {
				break;
			}

			swap(j, smallChild);
			j = smallChild;
		}
	}

	public void insert(K key) {
		heap.add(key);
		upheap(heap.size() - 1);
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	protected int left(int j) {
		return 2 * j + 1;
	}

	public K min() {
		return isEmpty() ? null : heap.get(0);
	}

	// Helper methods
	protected int parent(int j) { return (j - 1) / 2; }

	public K removeMin() {
		if (isEmpty()) {
			return null;
		}
		K answer = heap.get(0);
		// Move last element to root
		K last = heap.remove(heap.size() - 1);
		if (!heap.isEmpty()) {
			heap.set(0, last);
			downheap(0);
		}
		return answer;
	}

	protected int right(int j) {
		return 2 * j + 2;
	}

	public int size() {
		return heap.size();
	}

	private void swap(int i, int j) {
		K temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	private void upheap(int j) {
		// TODO: While j > 0 and parent > child, swap and move up
		while (j > 0) {
			int p = parent(j);
			if (heap.get(j).compareTo(heap.get(p)) >= 0) {
				break;
			} 
			swap(j, p);
			j = p;
		}
	}
}
