import java.util.*;
import edu.princeton.cs.algs4.*;

public class Parentheses {
	/*
	 * private static List<String> LeftParentheses = new ArrayList<String>() {{
	 * add("["); add("{"); add("("); }};
	 */
	private static Map<String, String> PairParentheses = new HashMap<String, String>() {
		{
			put("]", "[");
			put("}", "{");
			put(")", "(");
		}
	};

	public static void main(String[] args) { // Create a stack and push/pop strings as directed on StdIn.
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String items = StdIn.readString();
			String[] ary = items.split("");
			for (String item : ary) {
				StdOut.println("(" + item + ")");
				if (!PairParentheses.containsKey(item))
					s.push(item);
				else {
					String popString = s.pop();
					if(!PairParentheses.get(item).equals(popString)) {
						StdOut.println("false");
						return;
					}
				}
			}
		}
		if(s.size() != 0)
			StdOut.println("false");
		else 
			StdOut.println("true");
	}

}
