package hello;

public class JosList {
	ListNode rear, head, p;
    public JosList(int n,int m){
    	for(int i=1;i<=n-1;i++){
    	for(int j=1;j<m;j++)
    		rear=rear.next;
    	if(i==1){
    		head=rear.next;
    		p=head;
    	}else{
    		p.next=rear.next;
    		p=rear.next;
    	}
    	}
    }
}
