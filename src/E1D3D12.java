import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import implementation.Stack;

public class E1D3D12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> source = new Stack<>();
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			source.push(value);
		}
		Stack<String> Dest = copy(source);
		for(String item : source) {
			StdOut.print(item+" ");
		}
		StdOut.println("");
		for(String item : Dest) {
			StdOut.print(item+" ");
		}
	}
	
	private   static<Item> Stack<Item>copy(Stack<Item> source) {
		Stack<Item> dest = new Stack<Item>();
		Stack<Item> temp = new Stack<Item>();
		for(Item item : source) {
			temp.push(item);
		}
		
		for(Item item : temp) {
			dest.push(item);
		}
		return dest;
	}
}
