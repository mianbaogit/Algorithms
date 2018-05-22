package implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements java.lang.Iterable<Item> {
	private int n;
	private Node first;
	private Node last;

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void pushLeft(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (oldfirst == null) {
			last = first;
		} else {
			oldfirst.Previous = first;
		}
		n++;
	}

	public void pushRight(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.Previous = oldlast;
		if (oldlast == null) {
			first = last;
		} else {
			oldlast.next = last;
		}
		n++;
	}

	public Item popLeft() {
		Item item = first.item;
		first = first.next;

		if (first == null) {
			last = first;
		} else {
			first.Previous = null;
		}
		n--;
		return item;
	}

	public Item popRight() {
		Item item = last.item;
		last = last.Previous;

		if (last == null) {
			first = last;
		} else {
			last.next = null;
		}
		n--;
		return item;
	}

	private class DequeIterator implements java.util.Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			// TODO Auto-generated method stub
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}

	private class Node {
		Item item;
		Node next;
		Node Previous;
	}
}
