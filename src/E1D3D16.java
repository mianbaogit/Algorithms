import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class E1D3D16 {

	public static Date[] readDates(String name) {
		In in = new In(name);
		E1D3D14<Date> q = new E1D3D14<Date>();
		while (!in.isEmpty())
			q.enqueue(new Date(in.readString()));
		int N = q.size();
		Date[] a = new Date[N];
		for (int i = 0; i < N; i++)
			a[i] = q.dequeue();
		return a;
	}

	public static void main(String[] args) {
		String name = args[0];
		Date[] dates = readDates(name);
		for (Date item : dates) {
			StdOut.println(item);
		}
	}

}
