public class ArrayListStack<E> implements Stack<E> {
	private E[] data;
	private int top;

//constructor
	public ArrayListStack(int capacity) {
		data = (E[]) new Object[capacity];
		top = -1;
	}

	// check stack empty
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	// return top element
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack empty.");
		}
		return data[top];
	}

	@Override
	// remove AND return top element
	public E pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack underflow.");
		}
		E item = data[top];
		data[top--] = null;
		return item;
	}

	@Override
	// add element to top
	public void push(E item) {
		if (top == data.length - 1) {
			throw new IllegalStateException("Stack overflow.");
		}
		data[++top] = item;
	}
}
