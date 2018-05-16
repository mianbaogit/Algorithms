import java.util.Iterator;

public class Queue<Item> implements java.lang.Iterable<Item> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	private class Node {
		Item item;
		Node next;
	}

	private Node first;
	private Node last;
	private int N = 0;

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void enQueue(Item item) {
		Node oldLast = last;
		Node last = new Node();
		last.item = item;
		last.next = null;
		if (this.isEmpty())
			first = last;
		else
			oldLast.next = last;
		N++;
	}

	public Item deQueue() {
		Item item = first.item;
		first = first.next;
		if (this.isEmpty())
			last = null;
		N--;
		return item;
	}
	
	private class ListIterator implements java.util.Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
		}
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

}
