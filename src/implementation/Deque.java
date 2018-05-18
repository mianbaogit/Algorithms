package implementation;

public class Deque <Item>{

	private class Node{
		Item item;
		Node next;
		Node Previous;
	}
	
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
		if(oldfirst == null) {
			last = first;
		}else {
			oldfirst.Previous = first;
		}
		n++;
	}
	
	public void pushRight(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.Previous = oldlast;
		if(oldlast == null) {
			first = last;
		}else {
			oldlast.next = last;
		}
		n++;
	}
	
	public Item popLeft() {
		Item item = first.item;
		first = first.next;
		
		if(first == null) {
			last = first;
		}else {
			first.Previous = null;
		}
		n--;
		return item;
	}
	public Item popRight() {
		Item item = last.item;
		last = last.Previous;
		
		if(last == null) {
			first = last;
		}else {
			last.next = null;
		}
		n--;
		return item;
	}
}
