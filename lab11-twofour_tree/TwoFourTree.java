import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
	List<Integer> keys;
	List<TwoFourNode> children;
	TwoFourNode parent;

	public TwoFourNode() {
		keys = new ArrayList<>();
		children = new ArrayList<>();
		parent = null;
	}

	// Find correct child to descend for a given key
	public TwoFourNode getNextChild(int key) {
		// TODO: Implement traversal logic
		int i = 0;
		while (i < keys.size() && key > keys.get(i)) {
			i++;
		}
		return children.get(i);
	}

	// Insert a key into this node (assume node not full)
	public void insertKey(int key) {
		// TODO: Add key and sort
		keys.add(key);
		Collections.sort(keys);
	}

	// Check if node is full (3 keys)
	public boolean isFull() {
		return keys.size() == 3;
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}
}

public class TwoFourTree {

	private TwoFourNode root;

	public TwoFourTree() {
		root = new TwoFourNode();
	}

	// Inorder traversal
	public void inorder() {
		System.out.print("Inorder: ");
		inorder(root);
		System.out.println();
	}

	private void inorder(TwoFourNode node) {
		if (node == null) {
			return;
		}

		if (node.isLeaf()) {
			for (int key : node.keys) {
				System.out.print(key + " ");
			}
		} else {
			int i;
			for (i = 0; i < node.keys.size(); i++) {
				if (i < node.children.size()) {
					inorder(node.children.get(i));
				}
				System.out.print(node.keys.get(i) + " ");
			}
			if (i < node.children.size()) {
				inorder(node.children.get(i));
			}
		}
	}

	public void insert(int key) {
		TwoFourNode node = root;

		// 1. Descend to the leaf node
		while (!node.isLeaf()) {
			node = node.getNextChild(key);
		}

		// 2. Insert key in leaf
		node.insertKey(key);

		// 3. Handle overflow by splitting
		while (node != null && node.keys.size() > 3) {
			split(node);
			node = node.parent;
		}
	}

	private void split(TwoFourNode node) {
		System.out.println("Splitting node with keys: " + node.keys);

		int k0 = node.keys.get(0);
		int k1 = node.keys.get(1);
		int k2 = node.keys.get(2); // middle key to promote
		int k3 = node.keys.get(3);

		TwoFourNode left = node;
		left.keys = new ArrayList<>();
		left.keys.add(k0);
		left.keys.add(k1);

		TwoFourNode right = new TwoFourNode();
		right.keys.add(k3);
		right.parent = node.parent;

		if (!node.isLeaf()) {
			right.children.addAll(node.children.subList(2, node.children.size()));
			for (TwoFourNode child : right.children) {
				child.parent = right;
			}
			left.children = new ArrayList<>(node.children.subList(0, 2));
		}

		if (node.parent == null) {
			TwoFourNode newRoot = new TwoFourNode();
			newRoot.keys.add(k2);
			newRoot.children.add(left);
			newRoot.children.add(right);
			left.parent = newRoot;
			right.parent = newRoot;
			root = newRoot;
		} else {
			TwoFourNode parent = node.parent;
			parent.insertKey(k2);

			int index = parent.children.indexOf(node);
			parent.children.remove(index);
			parent.children.add(index, left);
			parent.children.add(index + 1, right);
			left.parent = parent;
			right.parent = parent;
		}
	}




}
