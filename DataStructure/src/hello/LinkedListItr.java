package hello;

public class LinkedListItr {
 LinkedListItr(ListNode theNode){
	 current=theNode;
 }
 public boolean isPastEnd(){
	 return current==null;
 }
 public Object retrieve(){
	 return isPastEnd()?null:current.element;
 }
 public void advance(){
	 if(!isPastEnd())
	 current=current.next;
 }
 ListNode current;
 
 public void insert(Object x,LinkedListItr p){
	 if(p!=null&&p.current!=null)
		 p.current.next=new ListNode(x,p.current.next);
 }
}
