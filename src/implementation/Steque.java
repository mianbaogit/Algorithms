package implementation;

public class Steque<Item> {

	private class Node {
		Item item;
		Node next;
	}

	private Node first = null;
	private Node last = null;
	private int n = 0;

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = first;

		if (this.isEmpty())
			last = node;

		first = node;
		n++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		n--;
		if (this.isEmpty())
			last = null;
		return item;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (this.isEmpty())
			first = last;
		else
			oldlast.next = last;
		n++;

	}
}
