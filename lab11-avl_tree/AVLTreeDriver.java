
public class AVLTreeDriver {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		// Insert test values to trigger all rotations
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);

		tree.insert(5);
		tree.insert(4);

		tree.insert(8);
		tree.insert(25);

		// Print traversals
		System.out.print("Inorder: ");
		tree.inorder(); // Should print sorted: 4 5 8 10 20 25 30

		System.out.print("Preorder: ");
		tree.preorder(); // Expected output: 10 5 4 8 20 15 30

		System.out.print("Postorder: ");
		tree.postorder(); // Expected output: 4 8 5 15 30 20 10
	}

}
