package Assign05;

public class BinaryTree {



	protected Node root;

	public BinaryTree() {

		root=null;
	}
	protected BinaryTree(Node root) {
		this.root=root;
	}




	public BinaryTree getLeftsubTree(){
		if(root!=null&& root.left!=null)
			return new BinaryTree (root.left);
		else 
			return null;
	}

	public BinaryTree getrighttsubTree(){

		if(root!=null&& root.right!=null)
			return new BinaryTree (root.right);
		else 
			return null;

	}
	public Node  TreeSearch(Node x,String k) { 
		if(x==null || k.equals(x.word)) { 
			return x; 


		}
		if (k.compareToIgnoreCase(x.word)<0  )
		{

			return TreeSearch(x.left,k); 

		}
		else return TreeSearch(x.right,k);


	}

	public Node  TreeSearch_Iterative(Node x,String k){
		while(x!=null && k.compareToIgnoreCase(x.word)!=0 ) { 
			if(k.compareToIgnoreCase(x.word)<0) {

				x=x.left;

			}
			else x=x.right; 

		}

		return x;


	} 

	public Node TreeMin(Node x){
		while(x.left!=null)
		{
			x=x.left;

		}
		return x;

	}

	public Node TreeMax(Node x){
		while(x.right!=null)
		{
			x=x.right;

		}
		return x;

	}

	public Node Successor(Node x){
		if(x.right!=null)
			return TreeMin(x.right);
		Node y=x.parent;
		while(y!=null &&x==y.right ) {

			x=y;
			y=y.parent;
		}

		return y;
	}

	public void TreeInsert(BinaryTree T,Node z) {


		Node y=null;
		Node x=T.root;
		while(x!=null) {
			y=x;
			if(z.word.compareToIgnoreCase(x.word)<0)

				x=x.left;
			else
				x=x.right;


		}
		z.parent=y;

		if(y==null)
			T.root=z;
		else if(z.word.compareToIgnoreCase(y.word)<0) {

			y.left=z;	

		}
		else
			y.right=z;


	}

	public Node TreeDelete(BinaryTree T,Node z) {
		Node x=null,y=null;
		if(z.left==null||z.right==null) 
			y=z; 
		else y=Successor(z); 

		if(y.left!=null) 
			x=y.left;  
		else  
			x=y.right; 

		if(x!=null) 
			x.parent=y.parent; 

		if(y.parent==null)
			T.root=x;
		else if(y==y.parent.left)
			y.parent.left=x;
		else y.parent.right=x;

		if(y!=z) {
			z.word=y.word;
			z.meaning=y.meaning;
			z.Class=y.Class;

		}
		return y;




	}
	public void inorder_tree(Node x) {
		
		if(x!=null) {
			inorder_tree(x.left);
			System.out.println(x.word+" ");
			
			inorder_tree(x.right);
		}
	}


	public int size(Node x) {
		
		if(x==null)
			return 0;
		
		return ( 1+size(x.left)+size(x.right) ) ;
		
	}



}