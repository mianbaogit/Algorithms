import java.util.Iterator;

public class Bag<Item> implements java.lang.Iterable<Item> {
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public void add(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;

	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
		}

	}

}
