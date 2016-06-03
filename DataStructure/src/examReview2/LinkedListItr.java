package examReview2;

public class LinkedListItr {
	//LinkedListItr——代表位置的类
	
	ListNode current;
	public LinkedListItr(ListNode theNode){
		current = theNode;
	}
	
	public boolean isPastEnd(){
		return current == null;
	}
	
	public Object retrieve(){
		return isPastEnd()?null:current.element;
	}
	
	public void advance(){
		if(!isPastEnd()){
			current = current.next;
		}
	}
	
	public static void printList(LinkedList theList){
		if(theList.isEmpty()){
			System.out.println("Empty list");
		}else{
			LinkedListItr itr = theList.first();
			for(;!itr.isPastEnd();itr.advance()){
				System.out.print(itr.retrieve()+" ");
			}
		}
		System.out.println();
	}
	
}
