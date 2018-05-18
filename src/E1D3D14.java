import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1D3D14<Item> implements java.lang.Iterable<Item> {

	private int first;
	private int last;
	private int n;
	private Item[] q;

	@SuppressWarnings("unchecked")
	public E1D3D14() {
		q = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}

	public int size() {
		return n;
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = q[(i + first) % q.length];
		}
		first = 0;
		last = n;
		q = temp;
	}

	public void enqueue(Item item) {
		// double size of array if necessary and recopy to front of array
		if (n == q.length)
			resize(2 * q.length); // double size of array if necessary
		q[last++] = item; // add item
		if (last == q.length)
			last = 0; // wrap-around
		n++;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item item = q[first];
		q[first] = null;
		n--;
		first++;

		if (first == q.length)
			first = 0;
		if (n > 0 && n == q.length / 4)
			resize(q.length / 2);
		return item;

	}

	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return q[first];
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {

		private int i;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < n;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = q[(i + first) % q.length];
			i++;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

	}

	

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		E1D3D14<String> queue = new E1D3D14<String>();
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			StdOut.println(value);
			queue.enqueue(value);
		}
		StdOut.println(k);
		int count = 0;
		for (String item : queue) {
			count++;
			if (count >= k) {
				StdOut.println(item);
			}
		}

	}

}
