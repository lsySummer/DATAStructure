package poly;

public class LinkList {
	Link p, q, d;
	Link first;

	public LinkList() {
		first = null;
	}

	public void create(float a, int b) {
		Link node = new Link(a, b);
		node.next = first;
		first = node;
	}

	public void padd(LinkList A, LinkList B) {
		float x;
		p = A.first;
		q = B.first;
		d = first;
		while ((p != null) && (q != null)) {
			if (p.exp == q.exp) {
//				System.out.println("p.exp=q.exp");
				x = p.coef + q.coef;
				if (x != 0) {
					Link node = new Link(x, p.exp);
					// make new Link
					node.next = d;
					d = node;
				}
				p = p.next;// move to next node of 'A'
				q = q.next;// move to next node of 'B'
			}
			else if(p.exp>q.exp){
//				System.out.println("p.exp>q.exp");
				Link node=new Link(q.coef,q.exp);
				node.next=d;
				d=node;
				q=q.next;
			}else{
//				System.out.println("p.exp<q.exp");
				Link node=new Link(p.coef,p.exp);
				node.next=d;
				d=node;
				p=p.next;
		
				}
			}
             while(p!=null){
            	 Link node=new Link(p.coef,p.exp);
            	 node.next=d;
            	 d=node;
            	 p=p.next;
		}
             while(q!=null){
            	 Link node=new Link(q.coef,q.exp);
            	 node.next=d;
            	 d=node;
            	 q=q.next;
            	 }
             first=d;
             }
	
	public void disp(){
		//to display the resultant polynomial
		Link current=first;//start at the beginning of the list
		while(current!=null){//until end of the list
			current.display();
			if(current.next!=null){
				System.out.println("+");
			}else{
				System.out.println(" ");
				//print data;
			}
			current=current.next;
			//move to next link
		}
		System.out.println(" ");	
	}

}
