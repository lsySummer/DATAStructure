package examReview1;

public class Node {
	int data;
	Node next;
	public Node(int data,Node next){
		this.data = data;
		this.next = next;
	}
	
	public int length(Node node){
		if(node == null){
			return 0;
		}else if(node.next == null){
			return 1;
		}else{
			return 1+this.length(node.next);
		}
	}
}

