public class Application {

	public static void main(String[] args) {
		//Binary Tree Test
		System.out.println("Binary Tree Test:");	
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(2);
		tree.insert(7);
		tree.insert(3);
		tree.insert(6);
		tree.insert(1);
		tree.insert(8);
		tree.printTree();
		System.out.println("Contains 7: " + tree.search(7));
		System.out.println("Contains 4: " + tree.search(4));
		System.out.println("remove(2)");
		tree.remove(2);
		tree.printTree();
		System.out.println("remove(1)");
		tree.remove(1);
		tree.printTree();
		System.out.println("remove(5)");
		tree.remove(5);
		tree.printTree();
	}
	
}
