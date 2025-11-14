class AVLNode {
	int key, height;
	AVLNode left, right;

	// Constructor
	AVLNode(int key) {
		this.key = key;
		this.height = 1; // height of a new node is 1
		this.left = null;
		this.right = null;
	}
}

public class AVLTree {
	AVLNode root;

	// Compute balance factor
	int getBalance(AVLNode N) {
		return N == null ? 0 : height(N.left) - height(N.right);
	}

	// Return height of a node
	int height(AVLNode N) {
		return N == null ? 0 : N.height;
	}

	// Traversals
	public void inorder() {
		inorder(root);
		System.out.println();
	}

	private void inorder(AVLNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.key + " ");
			inorder(node.right);
		}
	}

	// Recursive insertion with rebalancing
	private AVLNode insert(AVLNode node, int key) {
		// 1. Normal BST insertion
		if (node == null) {
			return new AVLNode(key);
		}

		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		} else {
			return node;
		}

		// 2. Update height
		node.height = 1 + max(height(node.left), height(node.right));

		// 3. Check balance factor
		int balance = getBalance(node);

		// 4. Perform rotations if unbalanced

		// Left Left Case
		if (balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			return leftRightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			return rightLeftRotate(node);
		}

		// Return the unchanged node pointer
		return node;
	}

	// Public insert method
	public void insert(int key) {
		root = insert(root, key);
	}

	// Left-Right rotation
	AVLNode leftRightRotate(AVLNode z) {
		z.left = leftRotate(z.left);
		return rightRotate(z);
	}

	// Left rotation
	AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		AVLNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Return maximum of two integers
	int max(int a, int b) {
		return a > b ? a : b;
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(AVLNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.key + " ");
		}
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(AVLNode node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	// Right-Left rotation
	AVLNode rightLeftRotate(AVLNode z) {
		z.right = rightRotate(z.right);
		return leftRotate(z);
	}

	// Right rotation
	AVLNode rightRotate(AVLNode y) {
		AVLNode x = y.left;
		AVLNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

}
