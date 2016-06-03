package binaryTree;

public class Tree {
private int data;//数据节点
private Tree left;
private Tree right;
//中序遍历为从小到大
	public Tree(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	//创建二叉树 返回跟结点
	public static Tree createTree(int []input){
	Tree root=null;
		Tree temp=null;
		for(int i=0;i<input.length;i++){
			//创建跟节点
			if(root==null){
				root=temp=new Tree(input[i]);
			}else{
				//回到跟结点
				temp=root;
				//添加节点
				while(temp.data!=input[i]){
					if(input[i]<=temp.data){
						if(temp.left!=null){
							temp=temp.left;
						}else{
							temp.left=new Tree(input[i]);
						}
					}else{
						if(temp.right!=null){
							temp=temp.right;
						}else{
							temp.right =new Tree(input[i]);
						}
					}
				}
			}
		}
		return root;
	}
	
	public static void preOrder(Tree tree){
		if(tree!=null){
			System.out.print(tree.data+"");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	public static void midOrder(Tree tree){
		if(tree!=null){
			midOrder(tree.left);
			System.out.print(tree.data+"");
			midOrder(tree.right);
		}
	}
	
	public static void posOrder(Tree tree){
		if(tree!=null){
			posOrder(tree.left);
			posOrder(tree.right);
			System.out.print(tree.data+"");
		}
	}
	public static void main(String[]args){
		int[]input={4,2,6,1,3,5,7,8,9};
		Tree t=createTree(input);
		System.out.println("前序遍历");
		preOrder(t);
		System.out.println("中序遍历");
		midOrder(t);
		System.out.println("后序遍历");
		posOrder(t);
		
		
	}
}
