package implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements java.lang.Iterable<Item> {

	private int first;
	private int last;
	private int n;
	private Item[] q;

	public RandomQueue() {
		q = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = q[(first + i) % q.length];
		}
		q = temp;
		first = 0;
		last = n;
	}

	public void enqueue(Item item) {
		if (n == q.length)
			this.resize(2 * q.length);
		q[last++] = item;
		if (last == q.length) {
			last = 0;
		}
		n++;
	}

	public Item dequeue() {
		if (this.isEmpty())
			throw new NoSuchElementException("Queue is empty");
		int index = (first + StdRandom.uniform(0, n)) % q.length;
		Item item = q[index];
		q[index] = q[first];
		q[first++] = null;
		n--;
		if (first == q.length)
			first = 0;
			
		if (n > 0 && n == q.length / 4)
			this.resize(q.length / 2);
		return item;
	}

	public Item sample() {
		if (this.isEmpty())
			throw new NoSuchElementException("Queue is empty");
		int index = (first + StdRandom.uniform(0, n)) % q.length;
		Item item = q[index];
		return item;
	}

	private class RandomIterator implements Iterator<Item> {
		Item[] temp = (Item[]) new Object[n];
		int i = 0;

		public RandomIterator() {
			for (int j = 0; j < n; j++) {
				int index = (first + StdRandom.uniform(j, n)) % q.length;
				temp[j] = q[index];
				q[index] = q[(first + j) % q.length];
				q[(first + j) % q.length] = temp[j];
			}
		}

		public boolean hasNext() {
			return i < n;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			return temp[i++];
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomIterator();
	}

	public static void main(String[] args) {
		RandomQueue<Integer> rd = new RandomQueue<>();
		for (int i = 0; i < 6; i++) {
			int r = StdRandom.uniform(100);
			rd.enqueue(r);
			StdOut.print(r + " ");
		}
		StdOut.println(" ");
		/*
		 * StdOut.println(rd); StdOut.println(rd.dequeue()); StdOut.println(rd);
		 * StdOut.println(rd.dequeue()); StdOut.println(rd);
		 */
		for (Integer i : rd) {
			StdOut.print(i + " ");
		}
		StdOut.println(" ");
		StdOut.println(rd.dequeue());
		
		for (Integer i : rd) {
			StdOut.print(i + " ");
		}
		StdOut.println(" ");
		StdOut.println(" --------------------------------------");
		rd.enqueue(3);
		rd.enqueue(4);
		StdOut.println(" --------------------------------------");
		for (Integer i : rd) {
			StdOut.print(i + " ");
		}
		StdOut.println(" ");
		for (Integer i : rd) {
			StdOut.print(i + " ");
		}

	}

}
