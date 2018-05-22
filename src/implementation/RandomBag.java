/**
 * 
 */
package implementation;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author X1 carbon
 * @param <Item>
 *
 */
public class RandomBag<Item> implements Iterable<Item> {

	private Node first;
	private int n;

	public RandomBag() {
		n = 0;
		first = null;
	}

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		n++;
	}

	private class RandomBagIterator implements Iterator<Item> {
		int i = 0;
		private Item[] items = null;

		public RandomBagIterator() {
			items = (Item[]) new Object[n];
			Node temp = first;
			int j = 0;
			while (temp != null) {
				items[j] = temp.item;
				j++;
				temp = temp.next;
			}
			shuffle();

		}

		private void shuffle() {
			for (int i = 0; i < n; i++) {
				int index = StdRandom.uniform(i, n);
				Item temp = items[i];
				items[i] = items[index];
				items[index] = temp;
			}
		}

		public boolean hasNext() {
			return i < n;
		}

		public void remove() {
			throw new UnsupportedOperationException("Remove is not supportted");
		}

		public Item next() {
			Item item = items[i];
			i++;
			return item;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomBagIterator();

	}

}
