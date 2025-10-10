public interface Stack<Enter> {
	boolean isEmpty();

	Enter peek();

	Enter pop();

	void push(Enter item);
}
