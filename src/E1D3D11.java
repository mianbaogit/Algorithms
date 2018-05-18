import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import implementation.Stack;

public class E1D3D11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> oprStack = new Stack<Integer>();

		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			StdOut.println(value);
			if ("+".equals(value)) {
				oprStack.push(oprStack.pop() + oprStack.pop());
			} else if ("-".equals(value)) {
				oprStack.push(oprStack.pop() - oprStack.pop());
			} else if ("*".equals(value)) {
				oprStack.push(oprStack.pop() * oprStack.pop());
			} else if ("/".equals(value)) {
				oprStack.push(oprStack.pop() / oprStack.pop());
			} else
				oprStack.push(Integer.parseInt(value));
		}
		StdOut.println(oprStack.pop());
	}

}
