import java.util.Iterator;

public class Stack<Item> implements java.lang.Iterable<Item> {

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

	private Node first; // stack entries
	private int N = 0; // size

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}

	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;
		N++;
	}

	public Item pop() {
		Node node = first;
		first = node.next;
		node.next = null;
		N--;
		return node.item;
	}

	public boolean isEmpty() {
		return first == null;// default
	}

	public int size() {
		return N;
	}

	private class Node {
		Item item;
		Node next;
	}

	private class ReverseArrayIterator implements Iterator<Item> {
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

}
