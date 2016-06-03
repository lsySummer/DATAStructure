package examReview2;

public class ListNode{
	//ListNode——代表结点的类
	
	Object element;
	ListNode next;
	public ListNode(Object theElement){
		this(theElement,null);
	}
	
	public ListNode(Object theElement,ListNode n){
		element = theElement;
		next = n;
	}

}

