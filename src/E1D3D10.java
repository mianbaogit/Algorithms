import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import implementation.Stack;

public class E1D3D10 {

	private static boolean isOperator(String s) {
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}
	public static void main(String args[]) {
		//String input = args[0];
		Stack<String> oprStack = new Stack<String>();
		Stack<String> dataStack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			StdOut.println(value);
			if (isOperator(value)) {
				oprStack.push(value);
			} else if (value.equals(")")) {
				String d1 = dataStack.pop();
				String d2 = dataStack.pop();
				String op = oprStack.pop();
				dataStack.push(d2 + " " + d1 + " "+ op );
			} else if (value.equals("(")) {
				
			}else 
				dataStack.push(value);
		}
		while(!oprStack.isEmpty()) {
			String d1 = dataStack.pop();
			String d2 = dataStack.pop();
			String op = oprStack.pop();
			dataStack.push(d2 + " " + d1 + " "+ op );
		}
		StdOut.println(dataStack.pop());
	}

}
