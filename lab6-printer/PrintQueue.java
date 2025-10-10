
public interface PrintQueue<T> {
	T dequeue();

	void enqueue(T item);

	boolean isEmpty();

}
