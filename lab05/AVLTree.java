package lab05;

public class AVLTree {
	private Node root;

	public AVLTree() {
		root = null;
	}

	private void printHelper(Node currPtr, String indent, boolean last) {
		// imprimir la estructura de árbol en la pantalla
		if (currPtr != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("R----");
				indent += "     ";
			} else {
				System.out.print("L----");
				indent += "|    ";
			}

			System.out.println(currPtr.data + "(BF = " + currPtr.bf + ")");

			printHelper(currPtr.left, indent, false);
			printHelper(currPtr.right, indent, true);
		}
	}

	private Node searchTreeHelper(Node node, int E) {
		if (node == null || E == node.data) {
			return node;
		}

		if (E < node.data) {
			return searchTreeHelper(node.left, E);
		}
		return searchTreeHelper(node.right, E);
	}

	private Node deleteNodeHelper(Node node, int E) {
		// busca la E
		if (node == null)
			return node;
		else if (E < node.data)
			node.left = deleteNodeHelper(node.left, E);
		else if (E > node.data)
			node.right = deleteNodeHelper(node.right, E);
		else {
			// la E ha sido encontrada, ahora bórrala

			// caso 1: el nodo es un nodo hoja
			if (node.left == null && node.right == null) {
				node = null;
			}

			// caso 2: el nodo tiene un solo hijo
			else if (node.left == null) {
				Node temp = node;
				node = node.right;
			}

			else if (node.right == null) {
				Node temp = node;
				node = node.left;
			}

			// Caso 3: tiene ambos hijos
			else {
				Node temp = minimum(node.right);
				node.data = temp.data;
				node.right = deleteNodeHelper(node.right, temp.data);
			}

		}

		return node;
	}

	// actualizar el factor de equilibrio del nodo
	private void updateBalance(Node node) {
		if (node.bf < -1 || node.bf > 1) {
			rebalance(node);
			return;
		}

		if (node.parent != null) {
			if (node == node.parent.left) {
				node.parent.bf -= 1;
			}

			if (node == node.parent.right) {
				node.parent.bf += 1;
			}

			if (node.parent.bf != 0) {
				updateBalance(node.parent);
			}
		}
	}

	// reequilibrar el árbol
	void rebalance(Node node) {
		if (node.bf > 0) {
			if (node.right.bf < 0) {
				rightRotate(node.right);
				leftRotate(node);
			} else {
				leftRotate(node);
			}
		} else if (node.bf < 0) {
			if (node.left.bf > 0) {
				leftRotate(node.left);
				rightRotate(node);
			} else {
				rightRotate(node);
			}
		}
	}

	private void preOrderHelper(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		}
	}

	private void inOrderHelper(Node node) {
		if (node != null) {
			inOrderHelper(node.left);
			System.out.print(node.data + " ");
			inOrderHelper(node.right);
		}
	}

	private void postOrderHelper(Node node) {
		if (node != null) {
			postOrderHelper(node.left);
			postOrderHelper(node.right);
			System.out.print(node.data + " ");
		}
	}

	// Recorrido de pre-pedido
	// Nodo.Subárbol izquierdo.Subárbol derecho
	public void preorder() {
		preOrderHelper(this.root);
	}

	// Recorrido en orden
	// Subárbol izquierdo. nodo Subárbol derecho
	public void inorder() {
		inOrderHelper(this.root);
	}

	// Recorrido posterior al pedido
	// Subárbol izquierdo. Subárbol derecho. Nodo
	public void postorder() {
		postOrderHelper(this.root);
	}

	// busca en el árbol la E k
	// y devolver el nodo correspondiente
	public Node searchTree(int k) {
		return searchTreeHelper(this.root, k);
	}

	// encontrar el nodo con el mínimo E
	public Node minimum(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	// encontrar el nodo con el máximo E
	public Node maximum(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	// encontrar el sucesor de un nodo dado
	public Node successor(Node x) {
		// si el subárbol derecho no es nulo,
		// El sucesor es el nodo más a la izquierda en el
		// subárbol derecho
		if (x.right != null) {
			return minimum(x.right);
		}

		// de lo contrario, es el ancestro más bajo de x cuyo
		// el hijo izquierdo también es un antepasado de x.
		Node y = x.parent;
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	// encontrar el predecesor de un nodo dado
	public Node predecessor(Node x) {
		// si el subárbol izquierdo no es nulo,
		// El predecesor es el nodo más a la derecha en el
		// subárbol izquierdo
		if (x.left != null) {
			return maximum(x.left);
		}

		Node y = x.parent;
		while (y != null && x == y.left) {
			x = y;
			y = y.parent;
		}

		return y;
	}

	// girar a la izquierda en el nodo x
	void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;

		// actualizar el factor de equilibrio
		x.bf = x.bf - 1 - Math.max(0, y.bf);
		y.bf = y.bf - 1 + Math.min(0, x.bf);
	}

	// girar a la derecha en el nodo x
	void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;

		// actualizar el factor de equilibrio
		x.bf = x.bf + 1 - Math.min(0, y.bf);
		y.bf = y.bf + 1 + Math.max(0, x.bf);
	}

	// inserte la E al árbol en su posición adecuada
	public void insert(int E) {
		// PARTE 1: inserto BST ordinario
		Node node = new Node(E);
		Node y = null;
		Node x = this.root;

		while (x != null) {
			y = x;
			if (node.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		// Y es padre de x
		node.parent = y;
		if (y == null) {
			root = node;
		} else if (node.data < y.data) {
			y.left = node;
		} else {
			y.right = node;
		}

		// PARTE 2: vuelva a equilibrar el nodo si es necesario
		updateBalance(node);
	}

	// eliminar el nodo del árbol
	Node deleteNode(int data) {
		return deleteNodeHelper(this.root, data);
	}

	// imprime la estructura de árbol en la pantalla
	public void prettyPrint() {
		printHelper(this.root, "", true);
	}

	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		bst.insert(100);
		bst.insert(200);
		bst.insert(300);
		bst.insert(400);
		bst.insert(500);
		bst.insert(50);
		bst.insert(25);
		bst.insert(350);
		bst.insert(375);
		bst.insert(360);
		bst.insert(355);
		bst.insert(150);
		bst.insert(175);
		bst.insert(120);
		bst.insert(190);
		System.out.println(" Arbol AVL despues de las inserciones:");
		bst.prettyPrint();

	}

	class Node {
		int data;
		Node parent;
		Node left;
		Node right;
		int bf;

		public Node(int data) {
			this.data = data;
			this.parent = null;
			this.left = null;
			this.right = null;
			this.bf = 0;
		}
	}
}