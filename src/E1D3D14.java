import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import implementation.ResizingArrayQueue;

public class E1D3D14<Item>{
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
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
