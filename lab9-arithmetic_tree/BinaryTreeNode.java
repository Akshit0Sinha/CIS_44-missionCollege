
public class BinaryTreeNode {
	String value; // Operator ("+") or operand ("3")
	BinaryTreeNode parent;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(String value) {
		this.value = value;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	/**
	 * Performs an inorder traversal starting from this node. (Visit Left, then
	 * Parent, then Right) This should output Infix notation (you can add
	 * parentheses for clarity).
	 */
	public void traverseInorder() {
		// Your code here
		// (Optional: Print "(" before recursing left)
		if (left != null) {
			System.out.print("(");
			left.traverseInorder();
		}
		// 1. Recursively call on left child (if not null)
		// 2. Print this node's value
		System.out.print(value + " ");

		// 3. Recursively call on right child (if not null)
		if (right != null) {
			right.traverseInorder();

			// (Optional: Print ")" after recursing right)
			System.out.print(")");
		}
	}

	/**
	 * Performs a postorder traversal starting from this node. (Visit Left, then
	 * Right, then Parent) This should output Postfix (RPN) notation.
	 */
	public void traversePostorder() {
		// Your code here
		// 1. Recursively call on left child (if not null)
		if (left != null) {
			left.traversePostorder();
		}

		// 2. Recursively call on right child (if not null)
		if (right != null) {
			right.traversePostorder();
		}

		// 3. Print this node's value
		System.out.print(value + " ");
	}

	// -- code --
	/**
	 * Performs a preorder traversal starting from this node.
	 * (Visit Parent, then Left, then Right)
	 * This should output Prefix notation.
	 */
	public void traversePreorder() {
		// 1. Print this node's value
		System.out.print(value + " "); 

		// 2. Recursively call on left child (if not null)
		if (left != null) {
			left.traversePreorder(); 
		}

		// 3. Recursively call on right child (if not null)
		if (right != null) {
			right.traversePreorder(); // Visit right subtree
		}
	}

}
