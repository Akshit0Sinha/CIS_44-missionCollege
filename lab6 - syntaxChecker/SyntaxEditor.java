public class SyntaxEditor {
	/**
	 * Uses a stack to check if a line of code has balanced symbols.
	 * 
	 * @param line The string of code to check.
	 * @return true if symbols are balanced, false otherwise.
	 */

	public static boolean Balanced(String line) {
		Stack<Character> buffer = new ArrayListStack<>(line.length());

		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);

			// Push opening symbols
			if (ch == '(') {
				buffer.push(ch);
			} else if (ch == '{') {
				buffer.push(ch);
			} else if (ch == '[') {
				buffer.push(ch);
			}

			// Handle closing symbols
			else if (ch == ')') {
				if (buffer.isEmpty()) {
					return false;
				}
				char top = buffer.pop();
				if (top != '(') {
					return false;
				}
			} else if (ch == '}') {
				if (buffer.isEmpty()) {
					return false;
				}
				char top = buffer.pop();
				if (top != '{') {
					return false;
				}
			} else if (ch == ']') {
				if (buffer.isEmpty()) {
					return false;
				}
				char top = buffer.pop();
				if (top != '[') {
					return false;
				}
			}

			// Ignore all other characters
		}

		// Balanced if stack is empty at the end
		return buffer.isEmpty();
	}

	public static void main(String[] args) {
		String line1 = "public static void main(String[] args) { ... }"; // t
		String line2 = "int x = (5 + [a * 2]);"; // t
		String line3 = "System.out.println('Hello');)"; // f
		String line4 = "List list = new ArrayList<{String>();"; // f
		String line5 = "if (x > 0) {"; // f

		System.out.println("Line 1 is balanced: " + Balanced(line1));
		System.out.println("Line 2 is balanced: " + Balanced(line2));
		System.out.println("Line 3 is balanced: " + Balanced(line3));
		System.out.println("Line 4 is balanced: " + Balanced(line4));
		System.out.println("Line 5 is balanced: " + Balanced(line5));


	}

}
