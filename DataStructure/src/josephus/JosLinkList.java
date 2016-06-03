package josephus;

public class JosLinkList {
	private LinkNode head;

	JosLinkList(int n) {//建立n个结点的单向循环链表
		int i = 1;//链表结点值为1到n
		LinkNode q, rear;
		if (n > 0) {
			head = new LinkNode(i);
			head.next = head;
			rear = head;
			while (i < n) {
				i++;
				q = new LinkNode(i);
				q.next = head;
				rear.next = q;
				rear = q;
			}//创造一个环形链表
		}

	}

	public void delete(LinkNode p) {// 删除p的后继结点
		LinkNode q = p.next;// q是p的后继结点
		System.out.println("Delete: " + q.data + " ");
		if (q == head)// 欲删除head指向结点时
			head = q.next;// 要将head向后移动
		p.next = q.next;// 删除q
	}

	public void output() {
		// 输出单项链表的各个结点值
		LinkNode p = head;
		System.out.println("Data: ");
		 do{
			System.out.print(p.data + "->");
			p=p.next;
		}while(p!=head);
		System.out.println();
	}

	public void display(int d) {//解约瑟夫环
		int j = 0;
		LinkNode p = head;
//		while (j < s - 1) {
//			// 计数起始点
//			j++;
//			p = p.next;
//		}
		while (p.next != p) {
			j = 1;
			while (j < d - 1) {
				j++;
				p = p.next;
			}
			delete(p);
			p = p.next;
			this.output();
		}
	}
	public static void main(String[]args){
		int n=8,d=3;
		JosLinkList j=new JosLinkList(n);
		j.output();
		j.display(d);
		
	}
}
