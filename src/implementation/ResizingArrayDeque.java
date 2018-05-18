package implementation;

public class ResizingArrayDeque<Item> {
	private int first;
	private int last;
	private int n;
	private Item[] q;

	@SuppressWarnings("unchecked")
	public ResizingArrayDeque() {
		q = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = q[(i + first) % q.length];
		}
		first = 0;
		last = n;
		q = temp;
	}

	public void pushLeft(Item item) {
		if (n == q.length) {
			resize(2 * q.length);
		}
		if(!this.isEmpty()) {
			first = (q.length + first - 1) % q.length;
		}
		
		q[first] = item;
		++n;
	}

	public void pushRight(Item item) {
		if (n == q.length) {
			resize(2 * q.length);
		}
		q[last++] = item;

		if (last == q.length) {
			last = 0;
		}
		++n;
	}

	public Item popLeft() {
		Item item = q[first];
		q[first] = null;
		first++;
		if (first == q.length)
			first = 0;
		--n;
		if (n > 0 && n == q.length / 4)
			resize(q.length / 2);
		return item;
	}

	public Item popRight() {
		last = (last - 1 + q.length) % q.length;
		Item item = q[last];
		q[last] = null;
		--n;
		if (n > 0 && n == q.length / 4)
			resize(q.length / 2);
		return item;
	}
}
