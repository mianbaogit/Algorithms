package implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements java.lang.Iterable<Item>{
	
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
        last  = n;
    }
	
	public void enqueue(Item item) {
		if(n == q.length)
			this.resize( 2 * q.length);
		q[last++] = item;
		if(last == q.length) {
			last = 0;
		}
		n++;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
