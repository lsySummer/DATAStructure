package examReview4;

public class BinaryNode {
	
	BinaryNode left, right;
	Object element;
	int leftSize;
	
	public BinaryNode() {
		left = null;
		right = null;
	}
	
	public BinaryNode(Object e){
		element = e;
		left = null;
		right = null;
	}
	
	public BinaryNode(Object e,BinaryNode l,BinaryNode r){
		element = e;
		left = l;
		right = r;
	}
	
	public Comparable findK(BinaryNode root,int k){
		if(root == null){
			return null;
		}
		if(k<root.leftSize){
			findK(root.left,k);
		}
		else if(k>root.leftSize){
			findK(root.right,k-root.leftSize);
		}
		else{
			return (Comparable) root.element;
		}
		return null;
	}
}
