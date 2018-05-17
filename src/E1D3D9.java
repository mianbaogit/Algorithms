import edu.princeton.cs.algs4.*;

public class E1D3D9 {

	/*public static String getCompleteExpression(String exp) {
		String[] params = exp.split(" ");
		Stack<String> oprStack = new Stack<String>();
		Stack<String> dataStack = new Stack<String>();
		for (int i = 0; i < params.length; i++) {
			if (isOperator(params[i])) {
				oprStack.push(params[i]);
			} else if (params[i].equals(")")) {
				String d1 = dataStack.pop();
				String d2 = dataStack.pop();
				String op = oprStack.pop();
				dataStack.push("( " + d2 + " " + op + " " + d1 + " )");
			} else {
				dataStack.push(params[i]);
			}
		}
		return dataStack.pop();
	}

	public static void main(String[] args) {
		String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		String result = getCompleteExpression(expression);
		System.out.println(result);
	}*/

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
				dataStack.push("( " + d2 + " " + op + " " + d1 + " )");
			} else {
				dataStack.push(value);
			}
		}
		StdOut.println(dataStack.pop());
	}
	

}
