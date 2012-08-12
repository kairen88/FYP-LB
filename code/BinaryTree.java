//---------------------------------------------------------------------------------
// CMPT - 275: Spring 2007
//
// Team name: Javangelists
// Project: Literature Repository
//
// Group Members:
// Wilson Tung, wtung1@sfu.ca
// Taylor Kagel, tdk@sfu.ca
// Joseph Kho, jmk3@sfu.ca
// Eric Chu, elc2@sfu.ca
//----------------------------------------------------------------------------------



public class BinaryTree 
{
	//Node class
	private class Node 
	{
		
		public Comparable data; //node data
		public Node right; //right child
		public Node left; //left child
	
		public Node(Comparable data) //node constructor
		{
			
			this(data, null, null);
		}
	
		public Node(Comparable data, Node left, Node right) //node constructor
		{
			
			this.data = data;
			this.left = left;
			this.right = right;
		}	
	}

	private Node root; // root variable
	private int size; //size variable
	
	public BinaryTree() //tree constructor 
	{
		size = 0;
		root = null;
	}
	
	//Goes through nodes of the tree in order and prints the data of each node.
	public void printTree() 
	{
		if(size == 0)
			System.out.println("Empty");
		else {
			System.out.println("Tree contents:");	
			inorder(root);
		}
	}
	
	//inOrder algorithm for printTree.
	public void inorder(Node current)
	{
		if(current != null) 
		{
			inorder(current.left);
			System.out.println(current.data);
			inorder(current.right);
		}
	}  
	 
	public void insert(Comparable data) 
	{
		root = insert(data, root);
	}
	
	//Insert helper method
	private Node insert(Comparable data, Node current) 
	{
		if( current == null ) //location found
		{
			size++; // increment size
			current = new Node(data, null, null); //create a new node and assign current to it
		}
		else if(data.compareTo(current.data)<0) //data is less than current node's data
		{
			current.left = insert(data,current.left); //call insert on current's left
		}
		else if(data.compareTo(current.data)>0) //data is greater than current node's data
		{
			current.right = insert(data, current.right); //call insert on current's right
		}		
		return current;
	}  
	
	/*
	Searches binary tree for a comparable object equal to the given object. Returns true
	if object is found and false otherwise.
	*/
	public boolean search(Comparable data) 
	{
		return search(data, root);	
	}
	
	//Search helper method
	private boolean search(Comparable data, Node current) 
	{
		
		if( current == null ) //data not found
		{
			return false;
		}
		else if(current.data == data)//data found
		{
			return true;	
		}
		else if(data.compareTo(current.data)<0)  //data is less than current node's data
		{
			return search(data, current.left); //search the left of current node
		}
		else //data is greater than current node's data
		{
			return search(data, current.right); //search the right of current node
		}
	}
	// Returns true if node with target data was deleted, false otherwise
	public boolean remove(Comparable key){
		if (search(key)){
			delete(key);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void delete(Comparable key) 
	{ 
//  	Algorithm note: There are four cases to consider:
//  	1. The node is a leaf.
//  	2. The node has no left child.
//  	3. The node has no right child.
//  	4. The node has two children.
		
		//initialize parent and current to root
		Node current = root;
		Node parent = root;
		
		boolean isLeftChild = true;
		
		//while loop to search for node to delete
		while(current.data.compareTo(key) != 0)        
		{
			//assign parent to current
			parent = current;
		 	if(current.data.compareTo(key) > 0)      
		    {
		    	isLeftChild = true; //current is a left child
		    	current = current.left; //make current's left child the current node
		    }
		 	else                            
		    {
		    	isLeftChild = false; //current is a right child
		    	current = current.right; //make current's right child the current node
		    }
		 	if(current == null)//data can't be found, break from loop              
		    	return ;            
		}   
//  	test for a leaf
		if(current.left == null && current.right == null) 
		{
			if(current == root) //tree has a single node, make root null 
		    	root = null;                
		 	else if(isLeftChild) //current is a left child so make its parent's left null	  
		    	parent.left = null;    
		 	else                             
		    	parent.right = null; //current is a right child so make its parent's right null  
		}
//  	test for no right child		
		else if(current.right == null)	 
			if(current == root) //current is root so make root point to current's left	 
		    	root = current.left; //old root gets deleted by garbage collector
			else if(isLeftChild) //current is a left child so make its parent's left point to it's left child
				parent.left = current.left;  
			else //current is a right child so make its parent's right point to it's left child
				parent.right = current.left;  
//  	test for no left child			
		else if(current.left == null)	 
			if(current == root) //current is root so make root point to current's right			 
		    	root = current.right; //old root gets deleted by garbage collector	 
			else if(isLeftChild) //current is a left child so make its parent's left point to it's right child		 
				parent.left = current.right; 
			else  //current is a right child so make its parent's right point to it's right child
				parent.right = current.right; 	
//  	there are two children:
//  	retrieve and delete the inorder successor
		else 
		{
 
			Node successor = getSuccessor(current); //get successor
		
		 	if(current == root)	 
		 	   	root = successor;
		 	else if(isLeftChild)	 
		    	parent.left= successor; //set node to delete to successor
		 	else
		    	parent.right = successor;
//		 	attach current's left to successor's left since successor has no left child		
		 	successor.left = current.left; 
		 }   
 	}
  
   //This method searches the successor of a node to be deleted
   private Node getSuccessor(Node delNode)
   {
		Node successorParent = delNode;	 
		Node successor = delNode;	 
		Node current = delNode.right; 
		
		while(current != null) 
		{ 
			
			successorParent = successor; 
			successor = current;			 
			current = current.left;			 
		}
		if(successor != delNode.right) 
		{ 
			
			successorParent.left = successor.right;	 
		 	successor.right = delNode.right;		 
		}
		return successor; 
   }
	
}
