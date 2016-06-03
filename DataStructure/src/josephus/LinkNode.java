package josephus;

public class LinkNode {
   public int data;//存放结点值
   public LinkNode next;//后继结点的引用
   public LinkNode(int k){//构造值为k的结点
	   data=k;
	   next=null;
   }
   public LinkNode(){//无参数时构造值为0的结点
	   this(0);
   }
   
}
