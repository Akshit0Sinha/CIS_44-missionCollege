import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionalList<E> implements Iterable<E> {
	// Iterator
	private class ElementIterator implements Iterator<E> {
		// position first to last
		private Position<E> cursor = first();
		private Position<E> recent = null;

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public E next() {
			if (cursor == null) {
				throw new NoSuchElementException();
			}
			recent = cursor;
			E element = cursor.getElement();
			cursor = after(cursor);
			return element;
		}

		@Override
		public void remove() {
			if (recent == null) {
				throw new IllegalStateException();
			}
			PositionalList.this.remove(recent);
			recent = null;
		}
	}

	// Node Class
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		@Override
		public E getElement() {
			// Sentinel node check
			if (next == null || prev == null) {
				throw new IllegalStateException("Position no longer valid");
			}
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}
	}

	private Node<E> header;
	private Node<E> trailer;

	private int size = 0;

	public PositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	// Mutators
	private Position<E> addBetween(E e, Node<E> pre, Node<E> nxt) {
		Node<E> newNode = new Node<>(e, pre, nxt);
		pre.setNext(newNode);
		nxt.setPrev(newNode);
		size++;
		return newNode;
	}

	// Public insertions
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		return position(validate(p).getNext());
	}

	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		return position(validate(p).getPrev());
	}

	public Position<E> first() {
		return position(header.getNext());
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	public Position<E> last() {
		return position(trailer.getPrev());
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer) {
			return null;
		}
		return node;
	}

	// Removes element at position and returns
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> pred = node.getPrev();
		Node<E> succ = node.getNext();
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		E element = node.getElement();
		// Help GC
		node.setPrev(null);
		node.setNext(null);
		node.setElement(null);
		return element;
	}

	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E old = node.getElement();
		node.setElement(e);
		return old;
	}

	//Accessors
	public int size() { return size; }

	// Private utility
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Invalid position");
		}
		Node<E> node = (Node<E>) p;
		// unusable node
		if (node.getNext() == null) {
			throw new IllegalArgumentException("Position no longer in list");
		}
		return node;
	}

}
