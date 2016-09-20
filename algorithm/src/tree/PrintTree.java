package tree;

public class PrintTree {

	public static void main(String[] args) {

	}

	public int printNodeAtLevel(Node node, int level) {

		if (node == null) {
			return 0;
		}

		if (level == 0) {
			System.out.print(node.value);
			return 1;
		}
		else {
			return printNodeAtLevel(node.left, level - 1) & printNodeAtLevel(node.right, level - 1);
		}
	}
}
