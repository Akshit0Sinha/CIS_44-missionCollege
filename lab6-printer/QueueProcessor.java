
public class QueueProcessor<T> implements PrintQueue<T> {
	// Node structure
	private class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node f;
	private Node r;

	// Initializes an empty queue
	public QueueProcessor() {
		f = r = null;
	}

	// removes and return to front of queue
	@Override
	public T dequeue() {
		if (f == null) {
			return null;
		}
		T item = f.data;
		f = f.next;
		if (f == null) {
			r = null;
		}
		return item;
	}

	// Adds an item to the rear
	@Override
	public void enqueue(T item) {
		Node node = new Node(item);
		if (r != null) {
			r.next = node;
		}
		r = node;
		if (f == null) {
			f = r;
		}
	}

	// if queue empty logic
	@Override
	public boolean isEmpty() {
		return f == null;
	}

}
