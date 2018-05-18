package implementation;

import java.util.Iterator;
import edu.princeton.cs.algs4.*;

public class FixedCapacityStack<Item> implements java.lang.Iterable<Item> {

	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];; // stack entries
	private int N; // size

	@SuppressWarnings("unchecked")
	private void resize(int max) { // Move stack of size N <= max to a new array
									// of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		// a[N++] = item;
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		// return a[--N];
		Item item = a[--N];
		a[N] = null; // Avoid loitering (see text).
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

}
