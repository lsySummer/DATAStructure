package examReview2;

public class UnionList{
	public LinkedList intersection(LinkedList l1,LinkedList l2){

		LinkedListItr itr1 = l1.first();
		LinkedListItr itr2 = l2.first();
		LinkedList l = new LinkedList();
		LinkedListItr itr = l.zeroth();
		
		while(!itr1.isPastEnd()&&!itr2.isPastEnd()){
			if(itr1.retrieve() == itr2.retrieve()){
				l.insert(itr1.retrieve(), itr);
				itr1.advance();
				itr2.advance();
			}else if(itr1.retrieve()!=itr2.retrieve()){
				itr1.advance();
			}else{
				itr2.advance();
			}
		}
		return l;
	}
}
