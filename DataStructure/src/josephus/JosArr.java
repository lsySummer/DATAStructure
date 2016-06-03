package josephus;

public class JosArr {

	public int Jos(int m,int n){
		int result=0;
		boolean []arr=new boolean[m];//用true和false表示是否还存在这个值
		for(int i=0;i<m;i++){
			arr[i]=true;
		}
		int leftCount=arr.length;//开始数那个人后边还有多少人
		int index=0;//下标初始化为0
		int countNum=0;//计数器的初始值为0
		while(leftCount>1){//最后那个人的后面没有人的话，循环结束
			if(arr[index]==true){
				countNum++;
				if(countNum==n){//当计数到n时，这个人被false，从新开始计数，活着的人的数组长度减一
					countNum=0;
					arr[index]=false;
					leftCount--;
				}
//				index++;
			}
			index++;//被false的那个人的，下一个人开始报数
		  if(index==arr.length){
			  //当数组的下标等于数组长度时，代表着从开始的那个人再次开始报数，新的循环开始
			  index=0;
		  }
	
		}
		for(int i=0;i<m;i++){
			if(arr[i]==true){
				result=i+1;
			}
		}
		return result;
	}
	public static void main(String[]args){
		JosArr j=new JosArr();
		System.out.println(j.Jos(8, 3));
	}
}
