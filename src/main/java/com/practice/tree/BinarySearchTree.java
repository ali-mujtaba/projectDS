import java.util.Scanner;

public class BinarySearchTree {
	BSTNode root;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree tree1 = new BinarySearchTree();
		for (int i = 0; i < 7; i++) {
			System.out.println("Enter element: ");
			tree1.add(scanner.nextInt());
		}


		BSTNode node1 = new BSTNode(50);
		BSTNode node2 = new BSTNode(25);
		BSTNode node3 = new BSTNode(75);
		BSTNode node4 = new BSTNode(15);
		BSTNode node5 = new BSTNode(35);
		BSTNode node6 = new BSTNode(65);
		BSTNode node7 = new BSTNode(85);

		// tree1.root = node1;
		// node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node2.right = node5;
		// node3.left = node6;
		// node3.right = node7;

		// System.out.println(node1.left.data);
		// System.out.println(node1.right.left.data);

		System.out.print("In-order Traversal: ");
		inorderTraversal(tree1.root);
		System.out.println();

		System.out.print("Pre-order Traversal: ");
		preorderTraversal(tree1.root);
		System.out.println();

		System.out.print("Post-order Traversal: ");
		postorderTraversal(tree1.root);
		System.out.println();

		System.out.println("35: " + tree1.find(35));
		System.out.println("37: " + tree1.find(37));
		System.out.println("delete 75");
		tree1.delete(75);
		inorderTraversal(tree1.root);

	}

	public void add(int element) {

		BSTNode node = new BSTNode(element);

		if (root == null) {
			root = node;
		} else {
			BSTNode current = root;
			while (true) {
				if (node.data <= current.data) {
					if (current.left == null) {
						current.left = node;
						break;
					}
					current = current.left;
				} else {
					if (current.right == null) {
						current.right = node;
						break;
					}
					current = current.right;
				}
			}
		}
	}

	public BSTNode find(int element) {
		BSTNode current = root;
		while (current != null) {
			if (element == current.data) {
				return current;
			} else if (element < current.data) {
				current = current.left;
			} else if (element > current.data) {
				current = current.right;
			}
		}
		return null;
	}

	public void delete(int element) {
		BSTNode key = this.root;
		BSTNode parent = null;
		while (key != null) {
			if (key.data == element) {
				break;
			} else {
				parent = key;
				if (key.data > element) {
					key = key.left;
				} else {
					key = key.right;
				}
			}
		}

		if (key == null) {
			System.out.println("Element not found! ");
			return;
		}

		if (key.left == null && key.right == null) {

			// when key has no child
			if (key == parent.left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (key.left != null && key.right != null) {

			// when key has no child
			BSTNode successor = getMin(key.right);
			if (successor == null) {
				successor = getMax(key.left);
			}

			int temp = successor.data;
			delete(successor.data);
			key.data = temp;
		} else {

			// when key has 1 child
			if (key.left == null) {
				key.data = key.right.data;
				key.left = key.right.left;
				key.right = key.right.right;
			} else {
				key.data = key.left.data;
				key.right = key.left.right;
				key.left = key.left.left;
			}
		}
	}


	public BSTNode getMin(BSTNode current) {
		BSTNode minNode = null;
		while (current != null) {
			minNode = current;
			current = current.left;
		}
		return minNode;
	}

	public BSTNode getMax(BSTNode current) {
		BSTNode maxNode = null;
		while (current != null) {
			maxNode = current;
			current = current.right;
		}
		return maxNode;
	}


	public static void inorderTraversal(BSTNode current) {

		if (current == null) {
			return;
		}

		inorderTraversal(current.left);
		System.out.print(current.data + " ");
		inorderTraversal(current.right);
	}

	public static void preorderTraversal(BSTNode current) {

		if (current == null) {
			return;
		}

		System.out.print(current.data + " ");
		preorderTraversal(current.left);
		preorderTraversal(current.right);
	}

	public static void postorderTraversal(BSTNode current) {

		if (current == null) {
			return;
		}
		postorderTraversal(current.left);
		postorderTraversal(current.right);
		System.out.print(current.data + " ");
	}
}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	BSTNode(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
}