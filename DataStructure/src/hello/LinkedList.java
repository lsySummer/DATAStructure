package hello;

public class LinkedList {
public LinkedList(){
	header=new ListNode(null);
}

public boolean isEmpty(){
	return(header.next==null);
}
public LinkedListItr zeroth(){
	return new LinkedListItr(header);
}
public LinkedListItr first(){
	return new LinkedListItr(header.next);
}

private ListNode header;
}
