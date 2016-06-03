package examReview2;

public class Reverse {
	public void reverse(LinkedList list){
		ListNode p1 = list.header.next;
		if(p1 == null){
			return;
		}
		ListNode p2 = p1.next;
		if(p2 == null){
			return;
		}
		ListNode p3 = p2.next;
		p1.next = null;
		
		while(p3!=null){
			p2.next = p1;
			p1 = p2;
			p2 = p3;
	        p3 = p3.next;
		}
	}
}
